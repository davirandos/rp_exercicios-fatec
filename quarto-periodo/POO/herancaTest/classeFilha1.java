package encapsulamento_1.herancaTest;

public class classeFilha1 extends superClasse{
    private String atributo2;

    classeFilha1() {
        super();
        System.out.println("Acesso ao método construtor da classe filha1");
    }

    public void setAtributo2(String atributo2) {
        this.atributo2 = atributo2;
    }

    public String getAtributo2() {
        return atributo2;
    }
}