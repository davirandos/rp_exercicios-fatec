package encapsulamento_1.nathalia;

public class MatoGrosso {
    private String nome;
    private int idade;
    private static String estado;

    MatoGrosso () {
    }

    MatoGrosso (String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    static {
        estado = "São Paulo";
    }

    public void mostraGrosso () {
        System.out.println("Nome: " + nome + "\n" + "Idade: " + idade + "\n" + "Estado: " + estado);
    }

}
