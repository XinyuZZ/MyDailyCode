package review;

abstract class AbstractClassDemo {
    int q = 2;
    abstract void helo();

}
class Impl extends AbstractClassDemo{
    public static void main(String[] args) {
        System.out.println(new Impl().q);
    }


    @Override
    void helo() {
         class das {

        }
        System.out.println(123);
    }
}
