package jensen;

public class Circle2 {
     static double radius = 1;
       static int numOfCircle = 0;

       Circle2(){
           numOfCircle++;
       }
    Circle2(int radius) {
        this.radius = radius;
        numOfCircle++;
    }

    double getArea() {
        return radius * radius * Math.PI;
    }
    public static void main(String[] args) {
        Circle2 circle1 = new Circle2(1);
        Circle2 circle2 = new Circle2(2);
        Circle2 circle3 = new Circle2(4);
        Circle2 circle4 = new Circle2(5);
        System.out.printf("Total %d circles created.\n", numOfCircle);
        System.out.println(Circle2.radius);
    }
}