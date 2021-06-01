public class Cylinder extends Circle{

    private int height;

    public Cylinder(int x, int y, int radius, int height){
        super(x,y,radius);
        System.out.println("원기둥 생성");
        this.radius = radius;
        this.height = height;
        this.x = x;
        this.y = y;

    }

    public double getArea(){return (2*Math.PI*Math.pow(radius,2)+(2*Math.PI*radius*height));}
    public double getVolume(){return (Math.PI*Math.pow(radius,2)*height);}

    public void printShape(){
        super.printShape();
        System.out.println("height : " + this.height);
    }
}