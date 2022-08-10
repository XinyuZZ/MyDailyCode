package jensen;


public class RegularPolygon {


    private int n;
    private double side;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        if (n >= 3)
            this.n = n;
        else
            System.err.println("The number of edges must be greater than three.");
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side >= 0)
            this.side = side;
        else
            System.err.println("The side length must be greater than or equal to zero.");

    }

    public RegularPolygon(int n, double side) {
        this.setN(n);
        this.setSide(side);
    }

    public RegularPolygon() {
        n = 3;
        side = 1;
    }

    public double getArea() {
        return n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n));
    }

    public double getPerimeter() {
        return n * side;
    }

    @Override
    public String toString() {
        return "The Regular Polygon n: " + n + ", side: " + side + ", area: " + String.format("%.2f", getArea()) + ", Perimeter: "
                + String.format("%.2f", getPerimeter());
    }
}

