package Laboratorium2;

public class Main {
    public static void main(String[] args) {
        MetodaProstokatow M_prostokatow = new MetodaProstokatow(2,3,6);
        MetodaTrapezow M_Trapezow = new MetodaTrapezow(1,5,6);
        MetodaSimpsona M_Simpsona = new MetodaSimpsona(4, 5, 6);

        M_prostokatow.start();
        M_Simpsona.start();
        M_Trapezow.start();

        while (M_prostokatow.isAlive() && M_Simpsona.isAlive() && M_Trapezow.isAlive()){
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double m_prostokatow = M_prostokatow.getCalka();

        double m_simpsona = M_Simpsona.getCalka();

        double m_trapezow = M_Trapezow.getCalka();
        System.out.printf("%.3f", m_prostokatow + m_simpsona + m_trapezow);

    }
}
