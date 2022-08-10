package s2122.test01.student;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String s = "212 12312 1231 12133 1311 213 ";
        Scanner scanner = new Scanner(s);
        int sum = 0;
        while (scanner.hasNextInt())
            sum += scanner.nextInt();
        System.out.println("Sum is " + sum);
    }
}
