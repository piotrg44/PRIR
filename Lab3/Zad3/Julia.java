package Zad3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Julia extends Thread {
    final static int N = 4096;
    final static int CUTOFF = 100;
    public static final double CX = -0.7;
    public static final double CY = 0.27015;
    static int[][] set = new int[N][N];
    private int me;

    public Julia(int me) {
        this.me = me;
    }

    public void run() {
        int begin = 0, end = 0;
        if (me == 0) {
            begin = 0;
            end = (N / 4) * 1;
        } else if (me == 1) {
            begin = (N / 4) * 1;
            end = (N / 4) * 2;
        } else if (me == 2) {
            begin = (N / 4) * 2;
            end = (N / 4) * 3;
        } else if (me == 3) {
            begin = (N / 4) * 3;
            end = N;
        }
        for (int i = begin; i < end; i++) {
            for (int j = 0; j < N; j++) {
                double cr = (4.0 * i - 2 * N) / N;
                double ci = (4.0 * j - 2 * N) / N;
                double zr = cr, zi = ci;
                int k = 0;
                while (k < CUTOFF && zr * zr + zi * zi < 4.0) {
                    // z = c + z * z
                    double newr = CX + zr * zr - zi * zi;
                    double newi = CY + 2 * zr * zi;
                    zr = newr;
                    zi = newi;
                    k++;
                }
                set[i][j] = k;
            }
        }
        // wyświetlanie rusunku
        BufferedImage img = new BufferedImage(N, N, BufferedImage.TYPE_INT_ARGB);
        // Rysowanie pixeli
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = set[i][j];
                float level;
                if (k < CUTOFF) {
                    level = (float) k / CUTOFF;
                } else {
                    level = 0;
                }
                Color c = new Color(0, level, 0);
                img.setRGB(i, j, c.getRGB());
            }
        }
        // zapis do pliku
        try {
            ImageIO.write(img, "PNG", new File("Julia.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

