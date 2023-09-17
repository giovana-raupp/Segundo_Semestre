--------------------------------------
-- TRABALHO TP3 - MORAES  16/MAIO/23
--------------------------------------
library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;

--------------------------------------
-- Entidade
--------------------------------------
entity tp3 is 
  port (clock   : in std_logic;
        reset   : in std_logic;
        din     : in std_logic;
        padrao  : in std_logic_vector(7 downto 0);
        prog    : in std_logic_vector(2 downto 0);
        dout    : out std_logic;
        alarme  : out std_logic;
        numero  : out std_logic_vector(1 downto 0);
        );
end entity; 

--------------------------------------
-- Arquitetura
--------------------------------------
architecture tp3 of tp3 is
  type state is (S0, COMP0, COMP1, COMP2, COMP3, BUSCANDO, BLOQUEIO, ZERAR); -- estados da maquina
  signal EA, PE: state;

  --Aqui escreve todos os signal do circuito

  signal data: std_logic_vector(7 downto 0) := "00000000";
 
  signal prog0: std_logic := '0';
  signal prog1: std_logic := '0';
  signal prog2: std_logic := '0';
  signal prog3: std_logic := '0';

  signal sel0: std_logic := '0';
  signal sel1: std_logic := '0';
  signal sel2: std_logic := '0';
  signal sel3: std_logic := '0';

  signal match0: std_logic := '0';
  signal match1: std_logic := '0';
  signal match2: std_logic := '0';
  signal match3: std_logic := '0';

  signal found: std_logic := '0';

  signal alarme_int: std_logic := '0';

begin  

  -- REGISTRADOR DE DESLOCAMENTO QUE RECEBE O FLUXO DE ENTRADA
  process(reset, clock)
  begin
    if reset = '1' then
      reg_din <= (others => '0');
    elsif rising_edge(clock) then
      reg_din <= din & reg_din(7 downto 1);
    end if;
  end process;

  -- 4 PORT MAPS PARA OS compara_dado 
  cd0_inst: entity work.compara_dado
    port map ( 
        clock => clock,
        reset => reset
        dado => data,
        padrao => pattern,
        prog => program(0),
        habilita => sel(0),
	      match => match(0)
       );

   cd1_inst: entity work.compara_dado
    port map (
        clock => clock,
        reset => reset
        dado => data,
        padrao => pattern,
        prog => program(1),
        habilita => sel(1),
        match => match(1) 
    );

    cd2_inst: entity work.compara_dado
    port map (
        clock => clock,
        reset => reset
        dado => data,
        padrao => pattern,
        prog => program(2),
        habilita => sel(2),
        match => match(2) 
    );

    cd3_inst: entity work.compara_dado
    port map (
        clock => clock,
        reset => reset
        dado => data,
        padrao => pattern,
        prog => program(3),
        habilita => sel(3),
        match => match(3) 
    );

    found  <=  match(0) or match(1) or match(2) or match(3);

  program(0) <= '1' when EA = COMP0 else '0';

  process(clock, reset)
  begin
  if reset = '1' then
  sel(0) <= '0';
  elsif rising_edge(clock) then    --  registradores para ativar as comparações + 3
  if EA=COMP0 then
  sel(0) <= '1';
  elsif EA= COMP1 then
  sel(0) <= '0';
  end if;
  end if;

  program(1) <= '1' when EA= COMP1 else '0';

  process(clock, reset)
  begin
  if reset = '1' then
  sel(1) <= '0';
  elsif rising_edge(clock) then
  if EA=COMP1 then
  sel(1) <= '1';
  elsif EA= COMP2 then
  sel(1) <= '0';
  end if;
  end if;

  program(2) <= '1' when EA= COMP2 else '0';

  process(clock, reset)
  begin
  if reset = '1' then
  sel(2) <= '0';
  elsif rising_edge(clock) then
  if EA=COMP2 then
  sel(2) <= '1';
  elsif EA= COMP3 then
  sel(2) <= '0';
  end if;
  end if;

  program(3) <= '1' when EA= COMP3 else '0';

  process(clock, reset)
  begin
  if reset = '1' then
  sel(3) <= '0';
  elsif rising_edge(clock) then
  if EA=COMP3 then
  sel(3) <= '1';
  elsif EA= S0 then
  sel(3) <= '0';
  end if;
  end if;

  --  registrador para o alarme interno

  process(clock, reset)
  begin
  if reset = '1' then
  alarme_int <= '0';
  elsif rising_edge(clock) then
  if EA = BUSCANDO then
  alarme_int <= found;
  elsif EA = ZERAR then
  alarme_in <= '0';
  end if;
  end if;
  end process;

  -- MAQUINA DE ESTADOS (FSM)
process (EA, prog, found)
begin
  case EA is
    when S0 =>
      if prog = "000" then
        PE <= S0;
      elsif prog = "001" then
        PE <= COMP0;
      elsif prog = "010" then
        PE <= COMP1;
      elsif prog = "011" then
        PE <= COMP2;
      elsif prog = "100" then
        PE <= COMP3;
      elsif prog = "101" then
        PE <= BUSCANDO;
      end if;
    when COMP0 =>
      if prog = "000" then
        PE <= S0;
      end if;
    when COMP1 =>
      if prog = "000" then
        PE <= S0;
      end if;
    when COMP2 =>
      if prog = "000" then
        PE <= S0;
      end if;
    when COMP3 =>
      if prog = "000" then
        PE <= S0;
      end if;
    when BUSCANDO =>
      if found = '1' then
        PE <= BLOQUEIO;
      elsif found = '0' then
        PE <= BUSCANDO;
      elsif prog = "111" then
        PE <= ZERAR;
      end if;
    when BLOQUEIO =>
      if prog = "110" then
        PE <= BUSCANDO;
      elsif prog = "111" then
        PE <= ZERAR;
      end if;
    when ZERAR =>
        PE <= S0;
  end case;
end process;

  -- SAIDAS
  alarme <= alarme_int;
  dout   <= din and not alarme_int;
  numero <= padrao;

end architecture;