public class Movie {

    private String title;
    private double grade;

    public Movie(String title, double grade){
        this.title = title;
        this.grade = grade;
    }

    public void printInformation(){
        System.out.println("\t ---- 영화 정보 ----");
        System.out.println("\t > 제목: "  + this.title);
        System.out.println("\t > 평점: " + this.grade + "점");
        System.out.println("\t -------------------");
    }
}
