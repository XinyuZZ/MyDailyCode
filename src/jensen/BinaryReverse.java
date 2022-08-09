package jensen;

import java.util.*;

public class BinaryReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputBinary = Integer.toBinaryString(scanner.nextInt());
        StringBuffer res = null;
//        Collections.reverseOrder();
        for (int i = 0; i < inputBinary.length(); i++) {
            int outputBinary = Integer.parseInt(inputBinary);
            res = new StringBuffer();
            while (outputBinary != 0) {
                int n1 = outputBinary % 10;
                outputBinary = outputBinary / 10;
                res.append(n1);
            }
        }

        System.out.println(Integer.parseInt(res.toString(),2));
    }
}

