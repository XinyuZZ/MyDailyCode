package review;

public class TestIn2 implements TestInt{


    @Override
    public double getDouble(Double k) {
        return Math.pow(k,4);
    }
}


class Test1{
    public static void main(String[] args) {

        TestInt a1 = new TestIn2();
        System.out.println( a1.getDouble(2.0));
    }

}
