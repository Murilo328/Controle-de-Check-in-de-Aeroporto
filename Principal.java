import estrutura.Fila;
import modelo.Passageiro;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Fila fila = new Fila();
        int opcao;

        do {
            System.out.println("\n===== CHECK-IN DE AEROPORTO =====");
            System.out.println("1 - Entrar na fila (enfileirar)");
            System.out.println("2 - Atender próximo passageiro (desenfileirar)");
            System.out.println("3 - Consultar próximo da fila");
            System.out.println("4 - Verificar se a fila está vazia");
            System.out.println("5 - Quantidade de passageiros na fila");
            System.out.println("6 - Exibir fila completa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = lerInteiro(entrada);

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();
                    System.out.print("Documento (CPF/Passaporte): ");
                    String documento = entrada.nextLine();
                    System.out.print("Voo: ");
                    String voo = entrada.nextLine();
                    System.out.print("Destino: ");
                    String destino = entrada.nextLine();
                    Passageiro novo = new Passageiro(nome, documento, voo, destino);
                    fila.enfileirar(novo);
                    System.out.println("Passageiro entrou na fila: " + novo);
                    break;
                case 2:
                    Passageiro atendido = fila.desenfileirar();
                    if (atendido == null) {
                        System.out.println("Não há passageiros aguardando atendimento.");
                    } else {
                        System.out.println("Check-in realizado para: " + atendido);
                    }
                    break;
                case 3:
                    Passageiro proximo = fila.primeiro();
                    if (proximo == null) {
                        System.out.println("A fila está vazia.");
                    } else {
                        System.out.println("Próximo da fila: " + proximo);
                    }
                    break;
                case 4:
                    if (fila.vazia()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        System.out.println("A fila possui passageiros aguardando.");
                    }
                    break;
                case 5:
                    System.out.println("Passageiros na fila: " + fila.tamanho());
                    break;
                case 6:
                    if (fila.vazia()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        System.out.println("--- Fila de check-in ---");
                        System.out.print(fila.exibir());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        entrada.close();
    }

    // Lê uma linha e converte para inteiro; devolve -1 se não for número.
    private static int lerInteiro(Scanner entrada) {
        String linha = entrada.nextLine();
        try {
            return Integer.parseInt(linha.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
