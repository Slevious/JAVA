public class Car {

    protected String name;
    protected int speed;

    public Car(String name, int speed){
        this.name = name;
        this.speed = speed;
    }


    public void drive(){
        System.out.println("주행 중 입니다.");
        System.out.println("현재 속도는 " + this.speed + " 입니다.");
    }

    public void brake() {
        System.out.println("브레이크를 밟았습니다.");
        System.out.println("차가 멈췄습니다.");
    }

    public void printCar(){
        System.out.println("=== Car 정보 출력 ===");
        System.out.println("자중: " + this.name);
        System.out.println("속도: " + this.speed);
    }
}
