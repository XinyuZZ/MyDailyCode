package review;

public class Max {
    public static void main(String[] args) {

        double list[] = {1, 2, 3.4, 2.4};
        new Max(list).maxFinder();
    }

    double list[];

    public Max(double[] list) {
        this.list = list;

    }

    void maxFinder() {

        double max = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        System.out.println(max);
    }
}