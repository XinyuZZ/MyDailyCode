package review;

public class Time {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.currentTimeMillis());
    }
}
