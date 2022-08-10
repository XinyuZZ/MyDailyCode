package jensen;

public class SwapReview626 {

    public static void main(String[] args) {
        Int num5 = new Int(5);
        Int num6 = new Int(6);
        System.out.println("Before swap: num5 = " + num5 + ", num6 = "+num6);
        swap(num5, num6);
        System.out.println("After swap: num = " + num5 + ", num6 = "+num6);
    }

    private static void swap(Int num5, Int num6) {
        int temp;
        temp = num5.value;
        num5.value = num6.value;
        num6.value = temp;
    }

    private static class Int {
        private int value;

        Int(int n) {
            value = n;
        }
        @Override
        public String toString() {
            return "123"+String.valueOf(value);
        }
    }
}
