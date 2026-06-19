import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HospitalTriagem {

    static class Paciente {
        String nome;
        int idade;
        String senha;
        String tipoAtendimento;
        boolean prioridade;

        Paciente(String nome, int idade, String senha, String tipoAtendimento) {
            this.nome = nome;
            this.idade = idade;
            this.senha = senha;
            this.tipoAtendimento = tipoAtendimento;
            this.prioridade = idade >= 60;
        }

        @Override
        public String toString() {
            String tag = prioridade ? "[PRIORIDADE]" : "[NORMAL]";
            return senha + " - " + nome + ", " + idade + " anos - " + tipoAtendimento + " " + tag;
        }
    }

    // Duas filas separadas: prioridade atende primeiro
    private Queue<Paciente> filaPrioridade = new LinkedList<>();
    private Queue<Paciente> filaNormal = new LinkedList<>();
    private int contCli = 0, contEmg = 0, contExa = 0;
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarPaciente(String nome, int idade, int tipo) {
        String senha;
        String tipoAtendimento;

        switch (tipo) {
            case 1:
                contCli++;
                senha = String.format("CLI%03d", contCli);
                tipoAtendimento = "Clínica Geral";
                break;
            case 2:
                contEmg++;
                senha = String.format("EMG%03d", contEmg);
                tipoAtendimento = "Emergência";
                break;
            case 3:
                contExa++;
                senha = String.format("EXA%03d", contExa);
                tipoAtendimento = "Exames";
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }

        Paciente p = new Paciente(nome, idade, senha, tipoAtendimento);

        if (p.prioridade) {
            filaPrioridade.add(p);
            System.out.println("✔ Paciente cadastrado como PRIORIDADE: " + p.senha);
        } else {
            filaNormal.add(p);
            System.out.println("✔ Paciente cadastrado como NORMAL: " + p.senha);
        }
    }

    public void chamarProximo() {
        Paciente p;

        // Prioridade sempre primeiro
        if (!filaPrioridade.isEmpty()) {
            p = filaPrioridade.poll();
        } else if (!filaNormal.isEmpty()) {
            p = filaNormal.poll();
        } else {
            System.out.println("⚠ Nenhum paciente na fila.");
            return;
        }

        System.out.println("\n🔔 Chamando: " + p.nome);
        System.out.println("   Senha: " + p.senha);
        System.out.println("   Atendimento: " + p.tipoAtendimento);
        System.out.println("   Tipo: " + (p.prioridade ? "PRIORIDADE (60+ anos)" : "NORMAL"));
    }

    public void listarFila() {
        boolean vazia = filaPrioridade.isEmpty() && filaNormal.isEmpty();
        if (vazia) {
            System.out.println("⚠ Nenhum paciente na fila.");
            return;
        }

        System.out.println("\n--- PRIORIDADE (" + filaPrioridade.size() + ") ---");
        int pos = 1;
        for (Paciente p : filaPrioridade) {
            System.out.println(pos++ + ". " + p);
        }
        if (filaPrioridade.isEmpty()) System.out.println("   (vazia)");

        System.out.println("\n--- NORMAL (" + filaNormal.size() + ") ---");
        pos = 1;
        for (Paciente p : filaNormal) {
            System.out.println(pos++ + ". " + p);
        }
        if (filaNormal.isEmpty()) System.out.println("   (vazia)");

        System.out.println("\nTotal na fila: " + (filaPrioridade.size() + filaNormal.size()));
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║    HOSPITAL - TRIAGEM        ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Cadastrar paciente       ║");
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
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Tipo de atendimento:");
                    System.out.println("  1. Clínica Geral (CLI)");
                    System.out.println("  2. Emergência (EMG)");
                    System.out.println("  3. Exames (EXA)");
                    System.out.print("Opção: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    cadastrarPaciente(nome, idade, tipo);
                    break;
                case 2: chamarProximo(); break;
                case 3: listarFila(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        new HospitalTriagem().menu();
    }
}
