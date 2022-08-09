package jensen;

import java.math.BigDecimal;


public class TestBigDecimal {
    public static void main(String[] args) {
        long max = Long.MAX_VALUE;
        System.out.println("The maximum value represented by Long type is: " + max);
        System.out.println("Adding one to 'max' results in overflow: " + (max + 1));
        BigDecimal big = new BigDecimal(max);
        BigDecimal one = new BigDecimal(1);
        BigDecimal sum = big.add(one);
        System.out.println("Adding one to 'big' does not overflow: " + sum);
        System.out.println("The unscaled value of sum is: " + sum.unscaledValue());
        System.out.println("The scale of sum is: " + sum.scale());
        System.out.println("100! is: "+ factorial((100)));
        System.out.println("100!/99! is: "+ factorial(100).divide(factorial(99)));
    }

    public static BigDecimal factorial(long n) {
        BigDecimal decimal = new BigDecimal(n);
        for (long i = n-1; i > 1; i--) {
            decimal= decimal.multiply(new BigDecimal(i));
        }
        return decimal;
    }

}