import java.util.Scanner;

public abstract class MyApp {

    public static void main(String[] args) {
        System.out.println("1. random value = " + Math.random());
        System.out.println("2. random value = " + Math.random());
        System.out.println("3. random value = " + Math.random());
//            Scanner scan = new Scanner(System.in);
//            System.out.print("i, j = ");
//            int i = scan.nextInt();
//            int j = scan.nextInt();
//
//            System.out.print("i와 j의 차이 " + Math.abs(i-j));
//            System.out.println("max = " + Math.max(i, j));
//            System.out.println("min = " + Math.min(i, j));
        double d = Math.random();
        System.out.println(d);
        d = d *10;
        System.out.println(d);
        System.out.println((int)d);
        System.out.println((int)d + 1);

        System.out.println((int)(Math.random() * 10) + 1);
    }

}
//        Int a = new Int(10);
//        Int b = new Int(20);
//
//        System.out.println("a = " + a.getI() + ", b = " + b.getI());
//        swapInt(a, b);
//        System.out.println("a = " + a.getI() + ", b = " + b.getI());
////        int a = 10;
////        int b = 20;
//        //참조형 Integer
////        Integer a = 10;
////        Integer b = 20;
////        System.out.println("a = " + a + " b = " + b);
//////        swapPrimitive(a,b);
////        swapReference(a, b);
////        System.out.println(("a = " + a + " b = " + b));


//    private static void swapReference(Integer a, Integer b){
//        System.out.println("swap -");
//        Integer temp = a;
//        a = b;
//        b = temp;
//    }

////        public static void swapPrimitive(int a, int b){
////            System.out.println("swap - ");
////            int temp = a;
////            a = b;
////            b = temp;
////        }
//    public static void swapInt(Int a, Int b) {
//        System.out.println("Swap");
//        int temp = a.getI();
//        a.setI(b.getI());
//        b.setI(temp);
//    }
//}
