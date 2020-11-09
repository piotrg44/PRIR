package Zad1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class Test {
    public static void main(String[] args) {
        Filozof filozof = new Filozof();
        int wariant = pobierzWariant();
        int filozofowie = pobierzFilozofow();
        filozof.ustawMax(filozofowie);

        for (int i = 0; i < filozof.MAX; i++) {
            filozof.widelec[i] = new Semaphore(1);
        }

        for (int i = 0; i < filozof.MAX; i++) {
            if (wariant == 1) {
                new Filozof1(i).start();
            } else if (wariant == 2) {
                new Filozof2(i).start();
            } else if (wariant == 3) {
                new Filozof3(i).start();
            }
        }
    }

    private static int pobierzWariant() {
        System.out.println("Podaj wariant 1, 2 lub 3 ");

        Scanner wariant = new Scanner(System.in);
        int wybranyWariant = wariant.nextInt();

        while (wybranyWariant != 1 && wybranyWariant != 2 && wybranyWariant != 3) {
            System.out.println("Wybierz wariant 1, 2 lub 3!!");
            wybranyWariant = wariant.nextInt();
        }

        return wybranyWariant;
    }

    private static int pobierzFilozofow() {
        System.out.println("Wybierz ile filozofow chcesz wybrac (od 2 do 100)");

        Scanner ileFilozofow = new Scanner(System.in);
        int iloscFilozofow = ileFilozofow.nextInt();

        while (iloscFilozofow < 2 || iloscFilozofow > 100) {
            System.out.println("Ilosc filozofow musi znajdowac sie w przedziale 2-100");
            iloscFilozofow = ileFilozofow.nextInt();
        }

        return iloscFilozofow;
    }
}