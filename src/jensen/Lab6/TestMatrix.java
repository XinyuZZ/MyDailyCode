//package jensen.Lab6;
//
//public class TestMatrix {
//    public static void main(String[] args) {
//// initialize both matrices
//        Matrix m1 = new Matrix(new int[][]{{5,15,0},{2,22,0}});
//        Matrix m2 = new Matrix(new int[][]{{5,6},{7,8}});
//        System.out.println("First matrix:");
//        m1.print();
//        System.out.println("Second matrix:");
//        m2.print();
//        System.out.println("");
//        System.out.println("Result of addition:");
//        try {
//            m1.multiply(m2).print(); // exception may occur
//        } catch(DimensionMisresulthException ex) {
//            System.out.println("Invalid matrix size: ");
//            System.out.println("First matrix:");
//            ex.getFirstMatrix().print(); // get and print the first matrix
//            System.out.println("Second matrix:");
//            ex.getSecondMatrix().print(); // get and print the second matrix
//        }
//    }
//}// exception may occur } catch(DimensionMisresulthException ex) { System.out.println("Invalid matrix size: "); System.out.println("First matrix:"); ex.getFirstMatrix().print(); // get and print the first matrix System.out.println("Second matrix:"); ex.getSecondMatrix().print(); // get and print the second matrix } } }