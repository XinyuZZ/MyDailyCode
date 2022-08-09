package jensen;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {

        int m = 0;
        int k = 0;
        double x, y;
        int i;

        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your throw times: ");
        int n = reader.nextInt();
        for (i = 0; i < n; i++) {
            x = Math.random();
            y = Math.random();

            k++;
            if (x * x + y * y <= 1)
                m++;
        }
        System.out.println(4 * (double) m / (double) n);


//        int i;
//        int nThrows = 0;
//        int nSuccess = 0;
//
//        double x, y;
//        Scanner reader = new Scanner(System.in);
//        int n = reader.nextInt();
//        for (i = 0; i < n ; i++)
//        {
//            x = Math.random();      // Throw a dart
//            y = Math.random();
//
//            nThrows++;
//
//            if ( x*x + y*y <= 1 )
//                nSuccess++;
//        }
//
//        System.out.println("Pi/4 = " + (double)nSuccess/(double)nThrows );
//        System.out.println("Pi = " + 4*(double)nSuccess/(double)nThrows );
    }

}







