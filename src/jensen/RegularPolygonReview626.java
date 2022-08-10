package jensen;

public class RegularPolygonReview626 {
    private int n = 3;
    private double side = 1;

    public RegularPolygonReview626() {
    }

    public RegularPolygonReview626(int n, double side) {
        setN(n);
        setSide(side);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        if (n >= 3) {
            this.n = n;
        } else
            System.err.println("The number of edges must be more or equal to three");
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side >= 0) {
            this.side = side;
        } else
            System.err.println("The side length must be more or equal to zero");
    }

    public double getPerimeter() {

        return this.n * this.side;
    }

    public static double getArea() {

        return 1;
    }

    @Override
    public String toString(){
        return "The regular polygon n: " + getN() + ", side: " + getSide() + ", Perimeter: " + getPerimeter();
    }
//
    public static void main(String[] args) {
        RegularPolygonReview626 polygon1 = new RegularPolygonReview626();
        RegularPolygonReview626 polygon2 = new RegularPolygonReview626(4, 2);
        RegularPolygonReview626 polygon3 = new RegularPolygonReview626(6, 3);
        System.out.println(polygon1);
        System.out.println(polygon2);
        System.out.println(polygon3);
    }
}
