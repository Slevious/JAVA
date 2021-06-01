public class Movie {



    private  String title;
    private  int releasseYear;
    private  double grade;

    public Movie(String title, int releasseYear, double grade){
        this.title = title;
        this.releasseYear = releasseYear;
        this.grade = grade;

    }

    public void printInformation(){
        System.out.println("----영화 제목----");
        System.out.println("제목 "  + this.title);
        System.out.println(">출시 연도 " + this.releasseYear);
        System.out.println(">평점 " + this.grade);
        System.out.println("------------");

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleasseYear() {
        return releasseYear;
    }

    public void setReleasseYear(int releasseYear) {
        this.releasseYear = releasseYear;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}