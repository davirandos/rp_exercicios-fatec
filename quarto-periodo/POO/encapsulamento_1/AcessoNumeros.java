package encapsulamento_1.encapsulamento_1;

public class AcessoNumeros {
    int a; // package-private
    public int b;
    private int c;
    protected int d;

    public void setNumero(String id, int numero) {
        if (id == "a")
            this.a = numero;

        if (id == "c")
            this.c = numero; // o "c" desse objeto recebe o valor de "numero" (direita para esquerda)

        // situações viáveis da utilização do "this":
        // referenciar uma variável de instância da classe de forma não ambígua
        // usar como argumento de um método de outra classe que vai chamar quando deseja passar o próprio objeto atual.

        if (id == "d")
            this.d = numero;
    }

    public void mostra_numero() {
        System.out.println("numero a = " + a);
        System.out.println("numero b = " + b);
        System.out.println("numero c = " + c);
        System.out.println("numero d = " + d);
    }
}
