import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LeituraArquivo {

    public static void main(String[] args) throws ParseException {
        
        ListaDeRuas listaDeRuas = new ListaDeRuas();
        
        int numLinhas = 0;
        
        // Ler o arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader("./dataEditado.csv", Charset.availableCharsets().get("UTF-8")))) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {

                String[] data = line.split(";");

                if (data[4] != "" && data.length < 14) {
                
                    DateTimeFormatter formatter;

                    if (data[4].contains("/"))
                        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    else 
                        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    int numInicial = 0;
                    int numFinal = 0;
                    String localDeInstalacao = "";

                    if (data[6] != "")
                        numInicial = (int) Double.parseDouble(data[6]);
                    
                    if (data[7] != "")
                        numFinal = (int) Double.parseDouble(data[7]);

                    if (data.length > 12)
                        localDeInstalacao = data[12];

                    listaDeRuas.insereOrdenado(data[5], 
                        new Sinalizacao(
                            data[1], 
                            LocalDate.parse(data[4], formatter), 
                            numInicial, 
                            numFinal, 
                            data[10], 
                            localDeInstalacao)
                    );
                }
                numLinhas++;

                line = reader.readLine();
            }
           

                
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(numLinhas);
        }


        listaDeRuas.reset();

        Menu menu = new Menu(listaDeRuas);
        menu.exibirMenu();
        
    }
}
