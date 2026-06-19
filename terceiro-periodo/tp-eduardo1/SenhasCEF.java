import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class SenhasCEF {

    // Cada senha guarda o código e o tipo de serviço
    static class Senha {
        String codigo;
        String tipoServico;

        Senha(String codigo, String tipoServico) {
            this.codigo = codigo;
            this.tipoServico = tipoServico;
        }

        @Override
        public String toString() {
            return codigo + " [" + tipoServico + "]";
        }
    }

    private Queue<Senha> fila = new LinkedList<>();
    private int contGerente = 0;
    private int contHabitacao = 0;
    private int contFinanciamento = 0;
    private Scanner scanner = new Scanner(System.in);

    public void gerarSenha(int tipo) {
        String codigo;
        String servico;

        switch (tipo) {
            case 1:
                contGerente++;
                codigo = String.format("GER%03d", contGerente);
                servico = "Gerente";
                break;
            case 2:
                contHabitacao++;
                codigo = String.format("HAB%03d", contHabitacao);
                servico = "Habitação";
                break;
            case 3:
                contFinanciamento++;
                codigo = String.format("FIN%03d", contFinanciamento);
                servico = "Financiamento";
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }

        Senha senha = new Senha(codigo, servico);
        fila.add(senha);
        System.out.println("✔ Senha gerada: " + senha);
    }

    public void chamarProxima() {
        if (fila.isEmpty()) {
            System.out.println("⚠ Nenhuma senha na fila.");
            return;
        }
        Senha senha = fila.poll();
        System.out.println("🔔 Chamando senha: " + senha);
    }

    public void listarFila() {
        if (fila.isEmpty()) {
            System.out.println("⚠ Fila vazia.");
            return;
        }
        System.out.println("\n--- Senhas na fila ---");
        int pos = 1;
        for (Senha s : fila) {
            System.out.println(pos++ + ". " + s);
        }
        System.out.println("----------------------");
    }

    public void mostrarProxima() {
        if (fila.isEmpty()) {
            System.out.println("⚠ Nenhuma senha na fila.");
        } else {
            System.out.println("➡ Próxima senha: " + fila.peek());
        }
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║    SENHAS - CAIXA ECONÔMICA  ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  Gerar senha:                ║");
            System.out.println("║    1. Gerente (GER)          ║");
            System.out.println("║    2. Habitação (HAB)        ║");
            System.out.println("║    3. Financiamento (FIN)    ║");
            System.out.println("║  4. Chamar próxima senha     ║");
            System.out.println("║  5. Listar fila              ║");
            System.out.println("║  6. Ver próxima senha        ║");
            System.out.println("║  0. Sair                     ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: gerarSenha(1); break;
                case 2: gerarSenha(2); break;
                case 3: gerarSenha(3); break;
                case 4: chamarProxima(); break;
                case 5: listarFila(); break;
                case 6: mostrarProxima(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        new SenhasCEF().menu();
    }
}
