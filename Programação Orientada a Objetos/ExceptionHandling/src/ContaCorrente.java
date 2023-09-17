public class ContaCorrente { 
    private double saldo; 

    public ContaCorrente(double saldoInicial) throws SaldoInicialException{
        if (saldoInicial <= 0) {
            throw new SaldoInicialException("O saldo inicial não pode ser nulo ou negativo");
        }
        saldo = saldoInicial;
    }

    public void deposito(double valor) throws ValorInvalidoException{ 
        validarValor(valor);
        saldo += valor; 
        }

    public void retirada(double valor) throws ValorInvalidoException{ 
        validarValor(valor);
        if (valor > saldo) {
                throw new SemSaldoException("Saldo insuficiente para realizar a retirada");
            }
            saldo -= valor;
    }

    public double getSaldo(){  
        return(saldo);    
    }

    private void validarValor(double valor) throws ValorInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Erro: Valor inválido"); // exceção verificada
		}
    }
	}


    


    