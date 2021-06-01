public class Suv extends Car {

    private boolean isExpanded;

    public Suv(String name, int speed, boolean isExpanded){
        super(name, speed);
        this.isExpanded = isExpanded;
    }

    public void printCar(){
        System.out.println("SUV!");
        super.printCar();
        System.out.print("좌석 확장 여부: ");
        if(isExpanded)
            System.out.println("O");
        else
            System.out.println("X");
        System.out.println("======================");
    }
}
