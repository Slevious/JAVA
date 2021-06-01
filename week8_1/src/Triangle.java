public class Triangle extends Shape{

    private int base;
    private int height;

    public Triangle(int x, int y, int base, int height){
        System.out.println("삼각형 생성");
        this.base = base;
        this.height = height;
        this.x = x;
        this.y = y;

    }

    public double getArea(){return (base*height*1/2);}

    public void printShape(){
        super.printShape();
        System.out.println("base: " + this.base + ", height : " + this.height);
    }
}