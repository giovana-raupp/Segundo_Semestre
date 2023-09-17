//Grupo 12: Giovana Raupp e Vitoria Gonzalez

import java.util.Scanner;
public class App {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Patio tremA = new Patio();
        int opcao, opcaoEdicao, tremId;
        
        System.out.println("\nBem vindo ao sistema de organização de trens!\n");

        do{
            opcao = menuPrincipal();
            switch(opcao){
                case 1:
                    boolean b = false;
                    do{
                        System.out.print("Informe o identificador do trem");
                        tremId = entrada.nextInt();
                        if(!tremA.checaIdTrem(tremId)){
                            b=true;
                        } else {
                            System.out.println("Um trem com esse identificador já existe");
                        }
                        
                    }while(!b);
                    tremA.listarLocomotivasLivres();
                    System.out.print("Insira o ID da primeira locomotiva");
                    int locomotivaId = entrada.nextInt();

                    tremA.criaTrem(tremId, locomotivaId);

                    break;
                case 2:
                    System.out.println(tremA);
                    System.out.print("Insira o ID do trem que deseja editar");
                    do{
                        tremId = entrada.nextInt();
                        b = tremA.checaIdTrem(tremId);
                        if(!b){
                            System.out.println("Insira um trem válido");
                        }
                    }while (!b);

                    do{
                        opcaoEdicao = menuEdicao();
                        switch(opcaoEdicao){
                            case 0:
                                System.out.println("Saindo da edição");
                                break;
                           
                            case 1:
                            tremA.inserirLocomotiva(tremId);
                                break;
                            
                            case 2:
                            tremA.inserirVagao(tremId);
                                break;
                            
                            case 3:
                            tremA.removerUltimo(tremId);
                                break;
                            
                            case 4:
                            tremA.listarLocomotivasLivres();
                                break;
                           
                            case 5:
                            tremA.listarVagoesLivres();
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                        
                    }while(opcaoEdicao != 0);
                    break;
                case 3:
                    System.out.println(tremA);
                    break;
                case 4:
                    System.out.println("Qual trem deseja desfazer? ");
                    tremId = entrada.nextInt();
                    if(!tremA.desfazTrem(tremId)){
                        System.out.println("Esse trem não existe");
                        opcao = 6;
                    }
                    break;
                case 5:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opcao != 5);
    }

    public static int menuPrincipal(){
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("Menu de opções");
            System.out.println("1 - Criar trem");
            System.out.println("2 - Editar trem");
            System.out.println("3 - Listar trens");
            System.out.println("4 - Desfazer trem");
            System.out.println("5 - Sair do programa");
            System.out.print("Qual opção deseja?  ");
            opcao = entrada.nextInt();
            if(opcao < 1 || opcao > 5){
                System.out.println("Opção inválida");
            } 
        } 
        
        while(opcao < 1 || opcao > 5);

        return opcao;
    } 

    public static int menuEdicao(){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("\n Menu de opções de edição do trem");
            System.out.println("1 - Inserir locomotiva");
            System.out.println("2 - Inserir vagão");
            System.out.println("3 - Remover último elemento do trem");
            System.out.println("4 - Listar locomotivas livres");
            System.out.println("5 - Listar vagões livres");
            System.out.println("0 - Parar de editar");
            System.out.print("Qual a opção desejada?");
            opcao = entrada.nextInt();
            if(opcao < 0 || opcao > 5){
                System.out.println("Opção inválida");
            }
            
        }while(opcao < 0 || opcao > 5);

        return opcao;
        
    }
}

