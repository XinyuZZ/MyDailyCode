package jensen;

public class TestSwap {
    /**
     * Pass by value
     */
    public static void swap1(int n1, int n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
    }

    /**
     * Pass by reference
     */
    public static void swap2(Integer n3, Integer n4) {
        Integer temp = n3;
        n3 = n4;
        n4 = temp;
    }
}