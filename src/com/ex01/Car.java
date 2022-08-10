
package com.ex01;

/**
 * @author vanting
 */
class Car {

    int speed;          // kilometer per hour
    int distance;       // kilometer
    static int numOfCars = 0;

    public Car(int s, int d) {

        this.speed = s;
        this.distance = d;
        Car.numOfCars++;
    }

    /**
     * Update the distance for driving of an hour
     */
    int move() {
        this.distance += this.speed;
        return this.distance;
    }

    public static void main(String[] args) {
        Car bus = new Car(5, 0);
        Car taxi = new Car(8, 0);

        System.out.println("No. of cars created: " + Car.numOfCars);
        System.out.println("Driving 1 hr: bus at " + bus.move() + "km and taxi at " + taxi.move() + "km");
        System.out.println("Driving 2 hrs: bus at " + bus.move() + "km and taxi at " + taxi.move() + "km");
    }
}
