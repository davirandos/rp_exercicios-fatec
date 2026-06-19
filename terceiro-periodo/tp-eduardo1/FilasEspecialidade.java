import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class FilasEspecialidade {

    static class Paciente {
        String nome;
        String codigo;
        String especialidade;

        Paciente(String nome, String codigo, String especialidade) {
            this.nome = nome;
            this.codigo = codigo;
            this.especialidade = especialidade;
        }
    }

    // Mapa com uma fila para cada especialidade
    private Map<String, Queue<Paciente>> filas = new HashMap<>();
    private Map<String, Integer>         contadores = new HashMap<>();
    private Map<String, String>          nomes = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public FilasEspecialidade() {
        filas.put("CLI", new LinkedList<>());
        filas.put("PED", new LinkedList<>());
        filas.put("ORT", new LinkedList<>());
        contadores.put("CLI", 0);
        contadores.put("PED", 0);
        contadores.put("ORT", 0);
        nomes.put("CLI", "CLÍNICA GERAL");
        nomes.put("PED", "PEDIATRIA");
        nomes.put("ORT", "ORTOPEDIA");
    }

    public void cadastrarPaciente(String nome, String sigla) {
        if (!filas.containsKey(sigla)) {
            System.out.println("Especialidade inválida.");
            return;
        }

        int num = contadores.get(sigla) + 1;
        contadores.put(sigla, num);
        String codigo = String.format("%s%03d", sigla, num);

        Paciente p = new Paciente(nome, codigo, sigla);
        filas.get(sigla).add(p);

        System.out.println("✔ " + nome + " adicionado(a) à fila de " + nomes.get(sigla) + " — Senha: " + codigo);
    }

    public void chamarPorEspecialidade(String sigla) {
        Queue<Paciente> fila = filas.get(sigla);
        if (fila == null) {
            System.out.println("Especialidade inválida.");
            return;
        }
        if (fila.isEmpty()) {
            System.out.println("⚠ Nenhum paciente aguardando em " + nomes.get(sigla) + ".");
            return;
        }

        Paciente p = fila.poll();
        System.out.println("\n🔔 Chamando " + p.nome + " para " + nomes.get(sigla));
        System.out.println("   Senha: " + p.codigo);
    }

    public void listarTodasFilas() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║       FILAS POR ESPECIALIDADE    ║");
        System.out.println("╚══════════════════════════════════╝");

        for (String sigla : new String[]{"CLI", "PED", "ORT"}) {
            Queue<Paciente> fila = filas.get(sigla);
            System.out.printf("\n▶ %s (%d paciente(s))%n", nomes.get(sigla), fila.size());
            if (fila.isEmpty()) {
                System.out.println("   Fila vazia.");
            } else {
                int pos = 1;
                for (Paciente p : fila) {
                    System.out.printf("   %d. %-20s [%s]%n", pos++, p.nome, p.codigo);
                }
            }
        }
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   HOSPITAL - ESPECIALIDADES  ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Cadastrar paciente       ║");
            System.out.println("║  2. Chamar - Clínica Geral   ║");
            System.out.println("║  3. Chamar - Pediatria       ║");
            System.out.println("║  4. Chamar - Ortopedia       ║");
            System.out.println("║  5. Listar todas as filas    ║");
            System.out.println("║  0. Sair                     ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Especialidade:");
                    System.out.println("  1. Clínica Geral (CLI)");
                    System.out.println("  2. Pediatria (PED)");
                    System.out.println("  3. Ortopedia (ORT)");
                    System.out.print("Opção: ");
                    int esp = scanner.nextInt();
                    scanner.nextLine();
                    String sigla = esp == 1 ? "CLI" : esp == 2 ? "PED" : esp == 3 ? "ORT" : "";
                    if (sigla.isEmpty()) System.out.println("Opção inválida.");
                    else cadastrarPaciente(nome, sigla);
                    break;
                case 2: chamarPorEspecialidade("CLI"); break;
                case 3: chamarPorEspecialidade("PED"); break;
                case 4: chamarPorEspecialidade("ORT"); break;
                case 5: listarTodasFilas(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        new FilasEspecialidade().menu();
    }
}
