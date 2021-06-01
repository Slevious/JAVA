import java.util.Random;

public class MyAPP {
    public static void main(String[] args) {
        Random random = new Random();
        int rand1 = random.nextInt(10) + 1;
        int rand2 = random.nextInt(10) + 1;

        System.out.println("2020270758 임광민");
        Shape shape = new Shape();
        printShapeInformation(shape);
        shape = new Rectangle(0, 0, rand1, rand2);
        printShapeInformation(shape);
        shape = new Circle(0, 0, rand2);
        printShapeInformation(shape);
        shape = new Cuboid(0,0,rand1,rand2,10);
        printShapeInformation(shape);
        shape = new Sphere(0,0,rand2);
        printShapeInformation(shape);
        shape = new Triangle(0,0,rand1,rand2);
        printShapeInformation(shape);
        shape = new Cylinder(0,0,rand1,rand2);
        printShapeInformation(shape);

    }

        public static void printShapeInformation(Shape shape){
            shape.printShape();
            System.out.print(shape.getClass().getName() + "넓이: " + String.format("%.2f",shape.getArea()) + "\n");

            if(shape instanceof Cuboid){
                Cuboid cuboid = (Cuboid) shape;
                System.out.println(cuboid.getClass().getName() + "부피: " + String.format("%.2f", cuboid.getVolume())+"\n");

            }

            if(shape instanceof Sphere){
                Sphere sphere = (Sphere) shape;
                System.out.println(sphere.getClass().getName() + "부피: " + String.format("%.2f", sphere.getVolume())+"\n");
            }

            if(shape instanceof Cylinder){
                Cylinder cylinder = (Cylinder) shape;
                System.out.println(cylinder.getClass().getName() + "부피: " + String.format("%.2f", cylinder.getVolume())+"\n");
            }

            System.out.println();
    }

}
