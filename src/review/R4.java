package review;

public class R4 {


    public static void main(String[] args) {
        int[] list1 = new int[]{1, 4, 1, 4};
        int[] list2 = new int[list1.length];


        list2 = list1;

// for (int i = 0; i < list2.length; i++) {
//     list2[i] = list1[i];
// }
        System.out.println(list1 == list2);

        for (int i = 0; i < list1.length; i++) {
            System.out.print(list1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < list2.length; i++) {
            System.out.print(list2[i] + " ");

        }
    }
}