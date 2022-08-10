package jensen.Lab5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {

        Set<String> A = new HashSet<>();
        Set<String> B = new HashSet<>();
        A.addAll(Arrays.asList("apple", "banana", "durian", "grape", "papaya"));
        B.addAll(Arrays.asList("banana", "mango", "papaya", "tomato", "watermelon"));
        System.out.println(A);
        System.out.println(B);
        Set<String> union = new HashSet<>();
        union.addAll(A);
        union.addAll(B);
        Set<String> intersection = new HashSet<>();
        Set<String> implement = new HashSet<>();
        System.out.println(union);
    }
}
