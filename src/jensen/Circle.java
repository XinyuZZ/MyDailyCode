package jensen;

public class Circle {

     private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    Circle(){
       this.radius=2.0;
    }


     Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString(){
         return ""+getArea();

    }
}
