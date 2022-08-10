package jensen;

import javax.swing.*;

public class Lab1 {

    public static void main(String[] args) {
        Integer numberOfLines = Integer.valueOf(JOptionPane.showInputDialog("Enter the number of lines: "));
//
        for (int i = 0; i < numberOfLines; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print("   ");
            }

            for (int k = numberOfLines - i; k > 1; k--) {
                System.out.printf("% 3d", k);
            }

            for (int m = 1; m <= numberOfLines - i; m++) {
                System.out.printf("% 3d", m);
            }
            System.out.println();
        }
    }
}

