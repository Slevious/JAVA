public class Movie {

    public static int movieCount = 0;
    private String title;
    private String director;
    private int runningTime;
    private int releaseYear;
    private int grade;

    public static int getMovieCount(){
        return movieCount;
    }
    public Movie(){
        movieCount++;
    }

    public Movie(String title, String director, int runningTime, int releaseYear, int grade){
        this.title = title;
        this.director = director;
        this.runningTime = runningTime;
        this.releaseYear = releaseYear;
        this.grade = grade;
        movieCount++;
    }

    public void printInformation(){
        System.out.println("제목 + " + this.title);
        System.out.println("감독 + " + this.director);
        System.out.println("상영시간 + " + this.runningTime);
        System.out.println("개봉연도 + " + this.releaseYear);
        System.out.println("평점 + " + this.grade);
    }
}
