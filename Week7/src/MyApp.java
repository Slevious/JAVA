import java.util.Scanner;

public class MyApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int row, col;
        Theater theater = new Theater(7,7);
        Movie movie = new Movie("find me", 4.5);
        theater.setMovie(movie);


        while(true){
            theater.printSeats();
            System.out.print("> 예매하고 싶은 좌석 입력(-1 입력시 종료): ");
            row = scan.nextInt();
            col = scan.nextInt();
            if(row == -1 || col == -1)
                break;

            row -= 1;
            col -= 1;
            theater.book(row, col);
            System.out.println();
        }
        System.out.println("프로그램 종료");
    }
}
