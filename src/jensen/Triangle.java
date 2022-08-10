package jensen;

public class Triangle extends Shape {
    private int height;

    private static final int MIDDLE = 40;

    public Triangle(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            drawChars(' ', MIDDLE - i);
            drawChars(getDrawingChar(), 2 * i - 1);
            System.out.println();
        }
// complete this method
    }

    @Override
    public String toString() {
        char drawingChar = getDrawingChar();
        return "Triangle(height:" + height + ", char:" + drawingChar + ")";
    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle(5);
        System.out.println(t1);
        t1.draw();
        Triangle t2 = new Triangle(10);
        t2.setDrawingChar('@');
        System.out.println(t2);
        t2.draw();
    }
}
