<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab11.functional;

import java.util.List;
import java.util.function.Function;

/**
 *
 * @author cwting
 */
public class MeanAge {

    public static void main(String[] args) {

        List<Person> list = Person.createShortList();
        
        Function<List<Person>, Double> meanOfAge
                = persons -> {
                    double sum = 0;
                    for(Person p : persons) {
                        sum += p.getAge();
                    }
                    return sum / persons.size();
                };
        
        System.out.println("The mean of the ages is:");
        System.out.println(meanOfAge.apply(list));
    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab11.functional;

import java.util.List;
import java.util.function.Function;

/**
 *
 * @author cwting
 */
public class MeanAge {

    public static void main(String[] args) {

        List<Person> list = Person.createShortList();
        
        Function<List<Person>, Double> meanOfAge
                = persons -> {
                    double sum = 0;
                    for(Person p : persons) {
                        sum += p.getAge();
                    }
                    return sum / persons.size();
                };
        
        System.out.println("The mean of the ages is:");
        System.out.println(meanOfAge.apply(list));
    }

}
>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
