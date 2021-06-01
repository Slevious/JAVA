public class Movie {

    private  String title;
    private  double grade;

    public Movie(String title, double grade){
        this.title = title;
        this.grade = grade;

    }

    public void printInformation(){
        System.out.println("----영화 제목----");
        System.out.println("제목 "  + this.title);
        System.out.println(">평점 " + this.grade);
        System.out.println("------------");

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}