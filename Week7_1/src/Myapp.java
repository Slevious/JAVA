import java.util.Scanner;

public class Myapp {

    public static void main(String [] args){

        MovieList movieList = new MovieList(3);

        movieList.writeInfo(0, "Aladdin", 2020, 4.5);
        movieList.writeInfo(1, "lala", 2012, 3);
        movieList.writeInfo(2, "end", 2013, 5);
        Scanner scan1 = new Scanner(System.in);
        String title;
        int year;
        double grade;
        for(int i =0; i<3; i++){
            System.out.println("영화 정보 입력");
            System.out.print("영화 제목: ");
            title = scan1.nextLine();
            System.out.print("개봉 연도: ");
            year = scan1.nextInt();
            System.out.print("평점: ");
            grade = scan1.nextDouble();
            movieList.writeInfo(i, title, year, grade);
            scan1.nextLine();
        }
        for(int i = 0; i <3; i++){
            movieList.printInfo(i);
        }

        movieList.printAll();

        System.out.println("연도를 입력해주세요");
        year = scan1.nextInt();
        movieList.findMoive(year);
    }
}
