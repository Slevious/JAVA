public class Movie {

    private String title;
    private int releaseYear;
    private double grade;

    public Movie(String title, int releaseYear, double grade){
        this.title = title;
        this.releaseYear = releaseYear;
        this.grade = grade;
    }

    public String toString(){
        return "영화 제목: " + title + ", 개봉 연도: " + releaseYear + ", 평점: " + grade;
    }
}

