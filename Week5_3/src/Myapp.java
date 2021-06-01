public class Myapp {
    public static void main(String [] args) {
        Calculator cal = new Calculator();

        int a = 10;
        int b = 20;

        double da = 2.8;
        double db = 1.4;

        String sa = "hello";
        String sb = "world";

        System.out.println("int > " + cal.add(a, b));
        System.out.println("double> " + cal.add(da,db));
        System.out.println("String > " + cal.add(sa,sb));

        System.out.println("int > " + cal.subtract(a,b));
        System.out.println("double > " + cal.subtract(da, db));
        System.out.println("String > " + cal.subtract(sa, sb));

    }
}
