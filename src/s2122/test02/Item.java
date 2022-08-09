package s2122.test02;

import java.util.HashSet;
import java.util.Set;

public class Item {

    public int[] values;


    public static void main(String[] args) {
        Item object = new Item();
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < object.values.length; i++) {
            hashSet.add(String.valueOf(object.values[i]));
        }
    }
}