package Zad2;

public class Port {
    static int PORT = 1;
    static int START = 2;
    static int LOT = 3;
    static int KONIEC_LOTU = 4;
    static int KATASTROFA = 5;
    int ilosc_kanalow;
    int ilosc_zajetych;
    int ilosc_statkow;

    Port(int ilosc_kanalow, int ilosc_statkow) {
        this.ilosc_kanalow = ilosc_kanalow;
        this.ilosc_statkow = ilosc_statkow;
        this.ilosc_zajetych = 0;
    }

    synchronized int start(int numer) {
        ilosc_zajetych--;
        System.out.println("Pozwolenie na odpłynięcie statkowi " + numer);
        return START;
    }

    synchronized int laduj() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception ie) {
        }
        if (ilosc_zajetych < ilosc_kanalow) {
            ilosc_zajetych++;
            System.out.println("Pozwolenie wpływanie kanałem " + ilosc_zajetych);
            return PORT;
        } else {
            return KONIEC_LOTU;
        }
    }

    synchronized void zmniejsz() {
        ilosc_statkow--;
        System.out.println("ZABILEM");
        if (ilosc_statkow == ilosc_kanalow) System.out.println("Ilosc statków taka sama jak miejsca w kanale");
    }
}
