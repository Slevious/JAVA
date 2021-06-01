import java.util.Scanner;

public class MyApp {

    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);
        int row, col;
        Theater theater = new Theater(7,7);
        Movie movie = new Movie("fine", 4.5);
        theater.setMovie(movie);

        while(true){
            theater.printSeats();
            System.out.println(">예매하려고하는 좌석 입력(행, 열)(-1 입력시 종료)");
            row = scan.nextInt();
            col = scan.nextInt();
            if(row == -1 || col == -1)
                break;

            theater.book(row, col);
        }
    }
}


