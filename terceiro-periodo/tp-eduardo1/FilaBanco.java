import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaBanco {

    private Queue<String> fila = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adicionarCliente(String nome) {
        fila.add(nome);
        System.out.println("✔ Cliente \"" + nome + "\" adicionado à fila.");
    }

    public void chamarProximo() {
        if (fila.isEmpty()) {
            System.out.println("⚠ Nenhum cliente na fila.");
            return;
        }
        String cliente = fila.poll();
        System.out.println("🔔 Chamando: " + cliente);
    }

    public void listarClientes() {
        if (fila.isEmpty()) {
            System.out.println("⚠ Fila vazia.");
            return;
        }
        System.out.println("\n--- Clientes na fila ---");
        int pos = 1;
        for (String cliente : fila) {
            System.out.println(pos++ + ". " + cliente);
        }
        System.out.println("------------------------");
    }

    public void mostrarQuantidade() {
        System.out.println("👥 Clientes na fila: " + fila.size());
    }

    public void mostrarProximo() {
        if (fila.isEmpty()) {
            System.out.println("⚠ Nenhum cliente na fila.");
        } else {
            System.out.println("➡ Próximo a ser atendido: " + fila.peek());
        }
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║      BANCO - FILA DE ATEND.  ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Adicionar cliente        ║");
            System.out.println("║  2. Chamar próximo           ║");
            System.out.println("║  3. Listar clientes          ║");
            System.out.println("║  4. Quantidade na fila       ║");
            System.out.println("║  5. Ver próximo              ║");
            System.out.println("║  0. Sair                     ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    adicionarCliente(scanner.nextLine());
                    break;
                case 2: chamarProximo(); break;
                case 3: listarClientes(); break;
                case 4: mostrarQuantidade(); break;
                case 5: mostrarProximo(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        new FilaBanco().menu();
    }
}
