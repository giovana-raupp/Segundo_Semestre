// Exercício realizado juntamente da colega Vitoria Gonzalez.
import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random ran = new Random();
        Cofrinho cofrinho = new Cofrinho();
        int moedinhas = NomeMoeda.values().length;
        int opcao;

        for(int pos = 0; pos < 10; pos++){
            NomeMoeda nome = NomeMoeda.values()[ran.nextInt(moedinhas)];
            cofrinho.Insere(new Moeda(nome));
        }

        System.out.println(cofrinho.toString());

        System.out.println("1 - Quantidade de moedas inseridas: " + cofrinho.getQtdadeMoedas());
        System.out.println("2 - Moedas de 1 real inseridas: " + cofrinho.getQtDeMoedasTipo(NomeMoeda.UmReal));
        System.out.println("3 - Moedas de 50 centavos inseridas: " + cofrinho.getQtDeMoedasTipo(NomeMoeda.Cinquenta) + "\n");
        System.out.println("4 - Valor total em centavos: " + cofrinho.getValorTotalCentavos());
        System.out.println("5 - Valor total em reais: " + cofrinho.getValorTotalReais() + "\n");

        System.out.println("Foi retirado " + cofrinho.Retira() + " do cofrinho");
        System.out.println("Foi retirado " + cofrinho.Retira() + " do cofrinho");
        System.out.println("Valor total em centavos atualizado: " + cofrinho.getValorTotalCentavos() + "\n");

        int res;
        do{
            opcao = menu();
            switch(opcao){
                case 0:
                    System.out.println("Fim do cofrinho");
                    break;
                case 1:
                    Moeda re = cofrinho.Retira();
                    System.out.println("Você recebeu " + re + ".");

                    System.out.println("Valor total em reais: " + cofrinho.getValorTotalReais());
                    break;
                case 2:
                    NomeMoeda moeda = criandoMoedinhas();
                    cofrinho.Insere(new Moeda(moeda));
                    
                    System.out.println("Valor total em reais: " + cofrinho.getValorTotalReais());
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }while(opcao != 0);
    }

    public static int menu(){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Menu de opções");
            System.out.println("1 - Retirar moeda");
            System.out.println("2 - Inserir moeda");
            System.out.println("0 - Sair");
            System.out.print("Qual sua opção? ");
            opcao = entrada.nextInt();
        }while(opcao < 0 || opcao > 2);

        if(opcao < 0 || opcao > 2){
            System.out.println("Opcão inválida");
        }
        return opcao;
    }
    
    public static NomeMoeda criandoMoedinhas(){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        NomeMoeda[] nomes = NomeMoeda.values();
        for(int pos = 0; pos < nomes.length; pos++){
            System.out.println(pos + " - " + nomes[pos]);
        }
        
        System.out.print("Qual moeda deseja inserir? ");
        opcao = entrada.nextInt();
        
        NomeMoeda nome = NomeMoeda.values()[(opcao)];
        return nome;
    }
}

