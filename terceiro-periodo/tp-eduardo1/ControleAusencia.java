import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ControleAusencia {

    static class Paciente {
        String nome;
        int vezesChamado;

        Paciente(String nome) {
            this.nome = nome;
            this.vezesChamado = 0;
        }

        @Override
        public String toString() {
            if (vezesChamado == 0) {
                return nome;
            }
            return nome + " (chamado " + vezesChamado + "x)";
        }
    }

    private Queue<Paciente> fila = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adicionarPaciente(String nome) {
        fila.add(new Paciente(nome));
        System.out.println("✔ Paciente \"" + nome + "\" adicionado à fila.");
    }

    public void chamarProximo() {
        if (fila.isEmpty()) {
            System.out.println("⚠ Nenhum paciente na fila.");
            return;
        }

        Paciente p = fila.poll();
        p.vezesChamado++;

        System.out.println("\n🔔 Chamando paciente: " + p.nome);
        System.out.println("   (Esta é a " + p.vezesChamado + "ª chamada)");
        System.out.print("   Paciente presente? (1 - SIM / 2 - NÃO): ");

        int resposta = scanner.nextInt();
        scanner.nextLine();

        if (resposta == 1) {
            System.out.println("✅ " + p.nome + " está sendo atendido(a).");
            System.out.println("   Total de chamadas até o atendimento: " + p.vezesChamado);
        } else {
            fila.add(p); // volta para o final da fila
            System.out.println("⚠ Paciente não presente. " + p.nome + " voltou para o final da fila.");
            System.out.println("  Já foi chamado " + p.vezesChamado + " vez(es).");
        }
    }

    public void listarFila() {
        if (fila.isEmpty()) {
            System.out.println("⚠ Fila vazia.");
            return;
        }
        System.out.println("\n--- Pacientes na fila ---");
        int pos = 1;
        for (Paciente p : fila) {
            System.out.println(pos++ + ". " + p);
        }
        System.out.println("   Total: " + fila.size() + " paciente(s)");
        System.out.println("-------------------------");
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   CONTROLE DE AUSÊNCIA       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Adicionar paciente       ║");
            System.out.println("║  2. Chamar próximo           ║");
            System.out.println("║  3. Listar fila              ║");
            System.out.println("║  0. Sair                     ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    adicionarPaciente(scanner.nextLine());
                    break;
                case 2: chamarProximo(); break;
                case 3: listarFila(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        new ControleAusencia().menu();
    }
}
