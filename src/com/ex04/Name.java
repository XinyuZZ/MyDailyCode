package com.ex04;

public final class Name implements Comparable {

    private String firstName;
    private char mi;
    private String lastName;

    /** Construct a name with firstName, mi, and lastName */
    public Name(String firstName, char mi, String lastName) {
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
    }

    /** Return firstName */
    public String getFirstName() {
        return firstName;
    }

    /** Return middle name initial */
    public char getMi() {
        return mi;
    }

    /** Return lastName */
    public String getLastname() {
        return lastName;
    }

    /** Obtain full name */
    public String getFullName() {
        return firstName + ' ' + mi + ' ' + lastName;
    }

    /** Implement compareTo in the Comparable interface */
    public int compareTo(Object o) {
        if (!lastName.equals(((Name) o).lastName)) {
            return lastName.compareTo(((Name) o).lastName);
        } else if (!firstName.equals(((Name) o).firstName)) {
            return firstName.compareTo(((Name) o).firstName);
        } else {
            return mi - ((Name) o).mi;
        }
    }



//    public static int compare(Object o1, Object o2) {
//
//        if (!((Name) o1).lastName.equals(((Name) o2).lastName)) {
//            return ((Name) o1).lastName.compareTo(((Name) o2).lastName);
//        } else if (!((Name) o1).firstName.equals(((Name) o2).firstName)) {
//            return ((Name) o1).firstName.compareTo(((Name) o2).firstName);
//        } else {
//            return ((Name) o1).mi - ((Name) o2).mi;
//        }
//    }
//
//    public static void main(String[] args) {
//        Name name1 = new Name("abd", 's', "11");
//        Name name2 = new Name("abc", 's', "11");
//        Person person1 = new Person();
//        Person person2 = new Person();
//        person1.setName(name1);
//        person2.setName(name2);
//
//
//    }
}
