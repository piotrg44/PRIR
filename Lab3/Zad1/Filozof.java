package Zad1;

import java.util.concurrent.Semaphore;

public class Filozof extends Thread {
    public static int MAX = 100;
    static Semaphore[] widelec = new Semaphore[MAX];
    int mojNum;

    public Filozof() {
    }

    public Filozof(int nr) {
        mojNum = nr;
    }

    public static void ustawMax(int iloscFilozofow) {
        MAX = iloscFilozofow;
    }
}
