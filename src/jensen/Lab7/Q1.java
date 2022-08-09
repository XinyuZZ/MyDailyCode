package jensen.Lab7;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) throws IOException {


//        FileOutputStream output = new FileOutputStream("lab7");
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("lab7"));
        for (int i = 0; i < 10_000_000; i++) {
            output.write(1);
        }
        output.close();
        FileInputStream input = new FileInputStream("lab7");
        int value;
        while ((value = input.read()) != -1) {
            System.out.print(value + " ");
        }

        // Close the output stream
        input.close();
    }
}
