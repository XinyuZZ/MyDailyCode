package jensen;

public class Shape {
    public char getDrawingChar() {
        return drawingChar;
    }

    public void setDrawingChar(char drawingChar) {
        this.drawingChar = drawingChar;
    }

    private char drawingChar = '*';
    protected static final int MIDDLE = 40;

    static protected void drawChars(char ch, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(ch);
        }
    }

    public void draw() {

    }
}
