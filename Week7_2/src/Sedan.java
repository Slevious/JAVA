public class Sedan extends Car{

    public Sedan(String name, int speed){
        super(name, speed);
    }

    public void printCar(){
        System.out.println("Sedan!");
        super.printCar();
        System.out.println("======================");
    }

    public void brake(){
        System.out.println("브레이크를 밟았습니다.");
        int speed = this.speed;
        while(true){
            System.out.println("현재 속도는 " + speed + " 입니다.");
            speed = Math.max(0, speed - 20);
            if(speed == 0)
                break;
        }
        System.out.println("차가 멈췄습니다.");
    }
}
