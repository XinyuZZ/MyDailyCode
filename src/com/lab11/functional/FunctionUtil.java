/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab11.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author vanting
 */
public class FunctionUtil {
    
    // Apply an action on each item in a list
    // e.g. T is Integer
    // Given a List<Integer> and a Consumer<Number>,
    // then we can pass an integer to action.accept(Number n)
    public static <T> void forEach(List<T> list, Consumer<? super T> action) {
        for (T item : list) {
            action.accept(item);
        }
    }

    //Apply a filter to a list, returned the filtered list items
    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Map each item of type T in a list to a value of type R
    public static <T, R> List<R> map(List<T> list, Function<? super T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for (T item : list) {
            mappedList.add(mapper.apply(item));
        }

        return mappedList;
    }
    
    //================================ lab 11 ===================================
    
    public static <T> Optional<T> min(List<T> list, Comparator<? super T> comparator) {
        
        if(list.isEmpty())
            return Optional.empty();
             
        T min = list.get(0);
        for (T item : list) {
            if (comparator.compare(min, item) > 0) {
                min = item;
            }
        }
        return Optional.of(min);
    }
}
