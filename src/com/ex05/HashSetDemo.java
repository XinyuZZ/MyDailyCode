/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex05;

import java.util.*;

/**
 * @author Van
 */
public class HashSetDemo {

    public static void main(String args[]) {
        // create hash set
        Set<String> set = new HashSet<>();

        // populate hash set
        set.add("Learning");
        set.add("Easy");
        set.add("Simply");

        // check the existence of element
        boolean exist = set.contains("Easy");
        System.out.println("Hash set values: " + set);
        System.out.println("Is the element 'Easy' exists: " + exist);
        System.out.println("");

        // remove "Easy" from set
        boolean isremoved = set.remove("Easy");
        System.out.println("Can remove?: " + isremoved);
        System.out.println("Values after remove: " + set);
        System.out.println("");

        // clear set values
        set.clear();
        System.out.println("Hash set values after clear: " + set);
        List<Integer> integers = new ArrayList<>();


        integers.add(2);
        integers.add(3);
        System.out.println(integers);
        Collections.reverse(integers);
        System.out.println(integers);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < integers.size(); i++) {
            buffer.append(integers.get(i));
        }
        System.out.println(buffer);


        List<Integer> integers1 = new ArrayList<>();


    }
}
