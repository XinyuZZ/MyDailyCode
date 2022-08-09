/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab11.functional;

import com.lab11.functional.Person.Gender;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author vanting
 */
public class FunctionUtilTest {

    public static void main(String[] args) {

        List<Person> list = Person.createShortList();

        // Use forEach() method to print each person in the list
        System.out.println("Original list of persons:");
        FunctionUtil.forEach(list, p -> System.out.println(p));

        // Filter only males
        List<Person> maleList = FunctionUtil.filter(list, p -> p.getGender() == Gender.MALE);

        System.out.println("\nMales only:");
        FunctionUtil.forEach(maleList, p -> System.out.println(p));

        // Map each person to his/her email
        List<String> emailList = FunctionUtil.map(list,
                p -> p.getEmail());

        System.out.println("\nPersons mapped to their email:");
        FunctionUtil.forEach(emailList, email -> System.out.println(email));

        // Apply an action to each person in the male list
        // Add one to each male's age
        FunctionUtil.forEach(maleList,
                p -> p.setAge(p.getAge() + 1));

        System.out.println(
                "\nMales only after adding 1 to age:");

        FunctionUtil.forEach(maleList, p -> System.out.println(p));

        //================================ lab 11 ===================================
        
        System.out.println("\nThe youngest person is:");
        Optional<Person> youngPerson = FunctionUtil.min(list, (p1, p2) -> p1.getAge() - p2.getAge());
        if(youngPerson.isPresent())
            System.out.println(youngPerson.get());
        else
            System.out.println("No person in the list.");
        
    }
}
