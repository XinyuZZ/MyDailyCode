<<<<<<< HEAD
package com.ex03;

public class PolymorphismDemo {

    public static void main(String[] args) {
        // I know nothing about the types of animals, just poke it!
        Fruit[] fruits = FruitStore.getSomeFruits();
        findColor(fruits);
    }

    public static void findColor(Fruit[] fruits) {
        for(int i=0; i<fruits.length; i++) {
            // dynamically bind to the subtype method
            fruits[i].color();
        }
    }
}


=======
package com.ex03;

public class PolymorphismDemo {

    public static void main(String[] args) {
        // I know nothing about the types of animals, just poke it!
        Fruit[] fruits = FruitStore.getSomeFruits();
        findColor(fruits);
    }

    public static void findColor(Fruit[] fruits) {
        for(int i=0; i<fruits.length; i++) {
            // dynamically bind to the subtype method
            fruits[i].color();
        }
    }
}


>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
