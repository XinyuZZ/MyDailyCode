package com.ex07;

import java.io.*;

public class TestFileStreams {

    public static void main(String[] args) throws IOException {
        // Create an output stream to the file
        FileOutputStream output = new FileOutputStream("temp.dat");
        PrintWriter out = new PrintWriter(output);
        // Output values to the file
        for (int i = 1; i <= 100; i++) {
            output.write(i);
        }

        // Close the output stream
        output.close();

        // Create an input stream for the file
        FileInputStream input = new FileInputStream("temp.dat");

        // Read values from the file
        int value;
        while ((value = input.read()) != -1) {
            System.out.print(value + " ");
        }

        // Close the output stream
        input.close();
    }
}
