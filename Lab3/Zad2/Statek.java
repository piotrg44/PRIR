package Zad2;

import java.util.Random;

public class Statek extends Thread {
    //definicja stanu statku
    static int PORT = 1;
    static int START = 2;
    static int REJS = 3;
    static int KONIEC_REJSU = 4;
    static int KATASTROFA = 5;
    static int TANKUJ = 1000;
    static int REZERWA = 500;
    //zmienne pomocnicze
    int numer;
    int paliwo;
    int stan;
    Port port;
    Random rand;

    public Statek(int numer, int paliwo, Port l) {
        this.numer = numer;
        this.paliwo = paliwo;
        this.stan = REJS;
        this.port = l;
        rand = new Random();
    }

    public void run() {
        while (true) {
            if (stan == PORT) {
                if (rand.nextInt(2) == 1) {
                    stan = START;
                    paliwo = TANKUJ;
                    System.out.println("W porcie, prosze o pozwolenie na start, statek " + numer);
                    stan = port.start(numer);
                } else {
                    System.out.println("Postoje sobie jeszcze troche");
                }
            } else if (stan == START) {
                System.out.println("Odcymowałem, statek  " + numer);
                stan = REJS;
            } else if (stan == REJS) {
                paliwo -= rand.nextInt(500);
                System.out.println("Statek " + numer + " płynie");
                if (paliwo <= REZERWA) {
                    stan = KONIEC_REJSU;
                } else try {
                    sleep(rand.nextInt(1000));
                } catch (Exception e) {
                }
            } else if (stan == KONIEC_REJSU) {
                System.out.println("Prosze o pozowolenie na zacumowanie " + numer + " ilosc paliwa " + paliwo);
                stan = port.laduj();
                if (stan == KONIEC_REJSU) {
                    paliwo -= rand.nextInt(500);
                    System.out.println("REZERWA " + paliwo);
                    if (paliwo <= 0) stan = KATASTROFA;
                }
            } else if (stan == KATASTROFA) {
                System.out.println("KATASTROFA statek " + numer);
                port.zmniejsz();
            }
        }
    }
}


