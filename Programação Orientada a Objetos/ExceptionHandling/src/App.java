import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        ContaCorrente conta = null;
        try {
            conta = new ContaCorrente(saldoInicial);
        } catch (SaldoInicialException e) {
            System.out.println(e.getMessage());
            return;
        }
        
            System.out.println("Saldo Total: " + conta.getSaldo());
            System.out.println("Insira a opção desejada: ");
            System.out.println("1 - Realizar depósito");
            System.out.println("2 - Realizar retirada");
            System.out.println("3 - Sair");
            int opcao = scanner.nextInt();
        
        switch (opcao) {
            case 1: 
                System.out.print("Informe o valor do depósito: ");
                double valorDep = scanner.nextDouble();
                try {
                    conta.deposito(valorDep);
                } catch (ValorInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            case 2:
                System.out.print("Informe o valor da retirada: ");
                double valorRetirado = scanner.nextDouble();
                try {
                    conta.retirada(valorRetirado);
                } catch (ValorInvalidoException e) {
                    System.out.println(e.getMessage());
                } catch (SemSaldoException e) {
                    System.out.println(e.getMessage());
                }
            case 3:
                break;
            default:
                System.out.println("Opção inválida");
            }
        }
    }



