package jensen;

import java.util.Scanner;

public class Lab2Review626 {
    public static void main(String[] args) {
        System.out.println("This programme approximates PI using the Monte Carlo method");
        System.out.print("Please enter number of throws (n):");
        Scanner attemptTimes = new Scanner(System.in);
        int attempTimes = attemptTimes.nextInt();
        int inCircle = 0;
        for (int i = 0; i < attempTimes; i++) {
            double x = Math.random();
            double y = Math.random();
            if (Math.pow(x, 2) + Math.pow(y, 2) < 1.0) {
                inCircle++;
            }
        }

        double estimatePI = 4 * Double.valueOf(inCircle) / Double.valueOf(attempTimes);

        System.out.println("Conputed PI = " +String.format("%.3f",estimatePI) + " Difference = " + Math.abs(estimatePI-Math.PI));
    }

}
