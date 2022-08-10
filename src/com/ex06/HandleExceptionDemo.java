<<<<<<< HEAD
package com.ex06;

import java.util.*;

public class HandleExceptionDemo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean continueInput = true;

    do {

      try {
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Display the result
        System.out.println("The number entered is " + number);

        continueInput = false;      // terminate loop
      }
      catch (InputMismatchException ex) {
        System.out.println("Try again. (Incorrect input: an integer is required)");
        scanner.nextLine();     // discard the incorrect input
      }

    } while (continueInput);
  }
}
=======
package com.ex06;

import java.util.*;

public class HandleExceptionDemo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean continueInput = true;

    do {

      try {
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Display the result
        System.out.println("The number entered is " + number);

        continueInput = false;      // terminate loop
      }
      catch (InputMismatchException ex) {
        System.out.println("Try again. (Incorrect input: an integer is required)");
        scanner.nextLine();     // discard the incorrect input
      }

    } while (continueInput);
  }
}
>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
