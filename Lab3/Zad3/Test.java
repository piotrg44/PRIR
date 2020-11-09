package Zad3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

class Test {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        Julia thread0 = new Julia(0);
        Julia thread1 = new Julia(1);
        Julia thread2 = new Julia(2);
        Julia thread3 = new Julia(3);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Obliczenia zakończone w czasie " + (endTime - startTime) + " millisekund");
    }

}
