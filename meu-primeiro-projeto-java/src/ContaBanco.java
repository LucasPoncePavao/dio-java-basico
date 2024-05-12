import java.util.Scanner;

// Classe que representa uma conta bancária
class Conta {
    private int numeroConta;
    private String titular;
    private double saldo;

    // Construtor
    public Conta(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0; // O saldo inicial é zero
    }

    // Método para depositar dinheiro na conta
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método para sacar dinheiro da conta
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    // Método para verificar saldo da conta
    public double verificarSaldo() {
        return saldo;
    }
}

// Classe para realizar a interação via terminal
public class ContaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita informações da conta ao usuário
        System.out.println("Informe o número da conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.println("Informe o titular da conta:");
        String titular = scanner.nextLine();

        // Cria uma nova conta com as informações fornecidas
        Conta conta = new Conta(numeroConta, titular);

        // Menu de opções
        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Verificar Saldo");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Informe o valor a ser sacado:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Saldo atual: R$" + conta.verificarSaldo());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
