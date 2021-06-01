public class MyApp {

    public static void main(String [] args){
        Suv suv = new Suv("XC90", 120, true);
        Sedan sedan = new Sedan("sm5", 100);

        suv.printCar();
        System.out.println();
        sedan.printCar();
        System.out.println();
        sedan.printCar();
        sedan.drive();
        sedan.brake();
    }
}
