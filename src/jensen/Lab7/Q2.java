package jensen.Lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Q2 {
    public File file;

    public Q2(String filename) {
        file = new File(filename);
    }

    public int countWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int words = 0;
        while (scanner.hasNext()) {
            scanner.next();
            words++;
        }
        return words;
    }

    public int countLines() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        return lines;
    }

    public int countCharacter() throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(file);
        int c;
        int nonWhiteSpace = 0;
        while ((c = reader.read()) != -1) {
            if (!Character.isWhitespace(c)) {
                nonWhiteSpace++;
            }
        }
        return nonWhiteSpace;
    }

    public static void main(String[] args) {
//        FileReader input = new FileReader("I Have a Dream Speech.txt");
        Q2 scanner = new Q2("I Have a Drweam Speech.txt");
        int nonWhitespace = 0;
//        scanner.useDelimiter(" ");

        int words = 0;
        int lines = 0;
        int character = 0;

        try {
            words = scanner.countWords();
            lines = scanner.countLines();
            character = scanner.countCharacter();


        } catch (FileNotFoundException ex) {
            Logger.getLogger(Q2.class.getName()).log(Level.SEVERE, "File not found", ex);

        } catch (IOException ex) {
            Logger.getLogger(Q2.class.getName()).log(Level.SEVERE, "Read file error", ex);
        }
        System.out.println(words);
        System.out.println(lines);
        System.out.println(character);
    }
}