package jensen.Lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q2ReverseOrder {


    public static void main(String[] args) {
        File in = new File("I Ha1ve a Dream Speech.txt");
        File out = new File("I Have Another Dream.txt");
        try {
            Scanner scanner = new Scanner(in);
            FileWriter writer = new FileWriter(out);
            ArrayList list = new ArrayList();

            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }

            for (int i = list.size(); i > 0; i--) {
                writer.write((String) list.get(i - 1) + "\n");
            }
            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Errors");
        }
    }
}
