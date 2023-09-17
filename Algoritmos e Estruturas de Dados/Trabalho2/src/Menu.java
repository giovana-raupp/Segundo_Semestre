import java.util.Scanner;

public class Menu {

    private ListaDeRuas listaDeRuas;
    private Scanner input;
    private String nomeDaRua;

    

    public String getNomeDaRua() {
        return nomeDaRua;
    }

    public Menu(ListaDeRuas listaDeRuas) {
        this.listaDeRuas = listaDeRuas;
        this.input = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("==== Menu ====");
            System.out.println("1. Avançar para próxima rua");
            System.out.println("2. Retroceder para rua anterior");
            System.out.println("3. Informações da rua atual");
            System.out.println("4. Rua com mais sinalizações");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    listaDeRuas.next();
                    break;
                case 2:
                    listaDeRuas.prev();
                    break;
                    case 3:
                    if (listaDeRuas.getRuaAtual() != null) {
                        System.out.println("Rua: " + listaDeRuas.getRuaAtual());
                        System.out.println("Número total de sinalizações: " + listaDeRuas.getNumeroTotalSinalizacoesRuaAtual());
                        System.out.println("Primeira sinalização registrada na rua: " + listaDeRuas.getPrimeiraSinalizacaoRuaAtual());
                        System.out.println("Última sinalização registrada na rua: " + listaDeRuas.getUltimaSinalizacaoRuaAtual());
                        System.out.println("Mes com Mais Sinalizações: " + listaDeRuas.getMesComMaisSinalizacoesRuaAtual());
                    } else {
                        System.out.println("Nenhuma rua selecionada.");
                    }
                    break;
                case 4:
                    String ruaComMaisSinalizacoes = listaDeRuas.getRuaComMaisSinalizacoes();
                    if (ruaComMaisSinalizacoes != null) {
                        System.out.println("Rua com mais sinalizações: " + ruaComMaisSinalizacoes);
                    } else {
                        System.out.println("Não há ruas cadastradas.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        }
    }
}
