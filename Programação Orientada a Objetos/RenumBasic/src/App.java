import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        List<String[]> programa = loadProgram("src/Prog1.bas"); // aqui muda o nome do arquivo

        Renumber.renum(programa);
    }

    public static ArrayList<String[]> loadProgram(String arquivo) { 
        String currDir = Paths.get("").toAbsolutePath().toString(); 
        String nameComplete = currDir+"\\"+ arquivo; 
        Path path2 = Paths.get(nameComplete); 

        ArrayList<String[]> lines = new ArrayList<>();

        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){ 
            while(sc.hasNextLine()) { 
                String line = sc.nextLine(); 
                String[] tokens = line.split(" "); 

                lines.add(tokens);
            } 
        }catch (IOException x){ 
            System.err.format("Erro de E/S: %s%n", x); 
        } 

        return lines;
    }

}
