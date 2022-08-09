/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex05;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vanting
 */
public class UnboundedWildcards {

    

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList2(ls);     //UnboundedWildcards.<String>printList2(ls);
//        printList3(li);
    }

    // this is not a generic method
    public static void printList(List<?> list) {    
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    
    // this is a generic method
    public static <T> void printList2(List<T> list) {
        for (T elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    
    public static void printList3(List<Object> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
        System.out.println();
    }


}
