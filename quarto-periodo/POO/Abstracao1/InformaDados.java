package encapsulamento_1.Abstracao1;

public class InformaDados {
    public static void main (String[] args) {
        DadosContribuinte a = new DadosContribuinte();

        a.setNome("Luccas Davi");
        a.setCPF("065.234.135-23");
        a.setCNPJ("789 980 /0002");
        a.setCartao("22432-1");

        System.out.println("nome: " + a.getNome());
        System.out.println("cpf: " + a.getCPF());
        System.out.println("cnpj: " + a.getCNPJ());
        System.out.println("cartao: " + a.getCartao());
    }
}
