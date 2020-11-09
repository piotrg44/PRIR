package Zad2;

public class Test {

    public static void main(String[] args) {
        int ilosc_statkow = 10;
        int ilosc_konalow = 5;
        Port port = new Port(ilosc_konalow, ilosc_statkow);
        for (int i = 0; i < ilosc_statkow; i++)
            new Statek(i, 2000, port).start();
    }
}
