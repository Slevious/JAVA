import java.util.Scanner;

public class MyApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int row, col;
        boolean [][] seats;
        Bus bus = new Bus(10,4);

        bus.printSeats();
        System.out.print("> 예매하고 싶은 좌석 입력(-1 입력시 종료): ");
        while(true){
            row = scan.nextInt();
            col = scan.nextInt();
            if(row == -1 || col == -1)
                break;
            row -= 1;
            col -= 1;
            bus.book(row, col);

        }
        System.out.println("프로그램 종료");
    }
}
