package encapsulamento_1.encapsulamento_1; // Mesmo pacote de acesso numeros

public class VerificaEncapsulamento {
    public static void main (String[] args) {
        AcessoNumeros chave = new AcessoNumeros(); // cria um novo objeto na memória
        // chave, nesse caso é uma variável de referência, guarda endereço do objeto.

        chave.a = 10; // as duas classes (verifica e acessa) estão no mesmo pacote
        chave.b = 20; // funciona em todo lugar, é public

        chave.setNumero("c", 30); // não é possível acessar variável private diretamente.
        // por isso, a solução é passar por um método público, nesse caso, setNumero

        chave.d = 40; // permite pois é o mesmo pacote
        chave.mostra_numero();
    }
}
