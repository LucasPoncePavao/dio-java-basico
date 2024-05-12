// Classe para realizar a interação via terminal

import java.util.Scanner;

public class ContaTerminal {
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

        // Solicita o número da agência
        System.out.println("Informe o número da agência:");
        int agencia = scanner.nextInt();

        // Exibe a mensagem de boas-vindas com as informações da conta
        System.out.println("Olá " + titular + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo " + conta.verificarSaldo() + " já está disponível para saque.");

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
