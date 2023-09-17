
public class App {
    public static void main(String[] args) {
        Funcoes f  = new Funcoes();
        
        for(int n=10; n<100; n+=10) {
            int r = f.f1(n);  
                             
            System.out.println(n+";"+r);
        }
            
    }
}
