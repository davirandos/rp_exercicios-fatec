package encapsulamento_1.encapsulamento_2;

import encapsulamento_1.encapsulamento_1.AcessoNumeros;

public class VerificaEncapsulamento_2 {
    public static void main(String[] args) {
        AcessoNumeros chave = new AcessoNumeros();

        // chave.a não funciona pois são pacotes diferentes
        chave.setNumero("a", 10);
        chave.b = 20; // público
        // chave.c não funciona pois é private
        chave.setNumero("c", 30);
        //chave.d não funciona pois também são de pacotes diferentes
        chave.setNumero("d", 50);

        chave.mostra_numero();
    }
}
