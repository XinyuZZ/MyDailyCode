package review;

public class R2 {

    public static void main(String[] args) {
        byte b = 10;
        byte f = (byte) (b+101101);
        int i = b + 1000; // byte to int
        double d = 1000; // int to double, lossy

        System.out.println(b);
        System.out.println(i);
        System.out.println(d);
        System.out.println(f);
    }
}
