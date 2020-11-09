package Zad1;

public class Filozof1 extends Filozof {
    public Filozof1(int nr) {
        super(nr);
    }

    public void run() {
        while (true) {

            System.out.println("Mysle ¦ " + mojNum);
            try {
                Thread.sleep((long) (7000 * Math.random()));
            } catch (InterruptedException e) {
            }
            widelec[mojNum].acquireUninterruptibly(); //przechwycenie L widelca
            widelec[(mojNum + 1) % MAX].acquireUninterruptibly(); //przechwycenie P widelca

            System.out.println("Zaczyna jesc " + mojNum);
            try {
                Thread.sleep((long) (5000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Konczy jesc " + mojNum);
            widelec[mojNum].release(); //zwolnienie L widelca
            widelec[(mojNum + 1) % MAX].release(); //zwolnienie P widelca
        }
    }
}
