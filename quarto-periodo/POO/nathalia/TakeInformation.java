package encapsulamento_1.nathalia;

import javax.swing.JOptionPane;

public class TakeInformation {
    public static void main (String[] args){
        MatoGrosso a = new MatoGrosso();
        a.mostraGrosso();

        MatoGrosso b = new MatoGrosso("Nathalia", 19);
        b.mostraGrosso();
    }
}
