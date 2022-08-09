package com.review;

public class Person {
    private Name name;
    private Address address;



    public Person(Name name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String toString(){
        return name.getName()+"\n"+address.getAddress();
    }
}
