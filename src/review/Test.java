package review;

public class Test {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Cat cat2 = (Cat) cat;
        cat2.eat();
    }
}

class Animal {
    public void eat() {
    }

    ;
}

class Cat extends Animal {
    public void eat() {
        System.out.println("吃老鼠");
    }
}

