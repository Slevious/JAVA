public class Movie {
    private String title;
    private int releaseYear;
    private double grade;

    public Movie(String title, int releaseYear, double grade){
        this.title = title;
        this.releaseYear = releaseYear;
        this.grade = grade;
    }

    public String toString() {return title;}

    public String getFullInfo(){
        String msg = "영화 제목: " + title + "\n개봉연도: " + releaseYear + "\n평점: " + grade;
        return msg;
    }
}
