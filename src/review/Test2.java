package review;

public class Test2 {

    public static void main(String[] args) {
        ShapeTest triangle = new Triangle(3);
        ShapeTest rectangle = new Rectangle(3);
        System.out.println("Triangle: " + triangle.calcLength());
        System.out.println("Rectangle: " + rectangle.calcLength());
    }
}

class Rectangle implements ShapeTest {
    double singleLength;

    Rectangle(double singleLength) {
        this.singleLength = singleLength;
    }

    public double calcLength() {
        return singleLength * 4;
    }
}

class Triangle implements ShapeTest {
    double singleLength;

    Triangle(double singleLength) {
        this.singleLength = singleLength;
    }

    public double calcLength() {
        return singleLength * 3;
    }
}
interface ShapeTest {
    int dsxx = 0;
    double calcLength();
}
