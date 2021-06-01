public class Myapp {

    public static void main(String [] args) {
        Movie s1 = new Movie("Aladdin", "R", 100, 2019, 4);
        s1.printInformation();

        Movie s2 = new Movie("lala", "C", 120, 2020, 5);
        s2.printInformation();

        Movie s3 = new Movie();
        s3.printInformation();

        System.out.println("총" + Movie.getMovieCount() + "개의 영화가 있습니다.");



    }
}
