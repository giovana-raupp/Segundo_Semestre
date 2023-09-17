import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Renumber {
    
    public static void renum(List<String[]> programa){
        HashMap<String, Integer> mapa = new HashMap<>();

        Integer lineNumber = 10;

        for (String[] line : programa) {
            mapa.put(line[0], lineNumber);
            line[0] = lineNumber.toString();

            lineNumber += 10;
        }

        for(String [] line : programa) {
            for (int i = 0; i < line.length; i++) {
                if (line[i].equalsIgnoreCase("goto") || line[i].equalsIgnoreCase("gosub")){ 
                }
            }
        }

        printer(programa);
    }

    public static void printer(List<String[]> programa) {
        try {
            FileWriter writer = new FileWriter("output.bas");

            for (String[] linha : programa) {
                StringBuilder sb = new StringBuilder(); 
                for (String string : linha) {
                    sb.append(string); // append = adiciona no final
                    sb.append(" ");
                }

                writer.write(sb.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

}
