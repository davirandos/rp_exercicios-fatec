package encapsulamento_1.herancaTest;

public class maine {
    public static void main(String[] args) {
        classeFilha2 a = new classeFilha2();
        classeFilha3 b = new classeFilha3();

        a.setAtributo1("valor do atributo 1");
        a.setAtributo2("valor do atributo 2");

        b.setAtributo1("valor do atributo 1.1");
        b.setAtributo2("valor do atributo 2.2");

        System.out.println(a.getAtributo1());
        System.out.println(b.getAtributo1());
        System.out.println(a.getAtributo2());
        System.out.println(b.getAtributo2());
    }
}
