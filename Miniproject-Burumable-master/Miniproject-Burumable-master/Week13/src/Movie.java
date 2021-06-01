public class Movie {
     //기본 세팅, Frame, Gen 이용
    private String title;
    private int releaseYear;
    private double grade;

    public Movie(String title, int releaseYear, double grade){
        this.title = title;
        this.releaseYear = releaseYear;
        this.grade = grade;
    }

    //Frame 추가시 이용
    public int getReleaseYear() {return releaseYear;}

    public String toString(){
        return "영화 제목: " + title + ", 개봉 연도: " + releaseYear + ", 평점: " + grade;
    }
}
