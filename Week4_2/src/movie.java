public class movie {

    private  String title;
    private String director;
    private int runningTime;
    private int releaseYear;
    private int grade;

    public movie(){}

    public movie(String title, int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle(){return title;}
    public int getReleaseYear(){return releaseYear;}
    public void setTitle(String title){this.title = title;}
    public void setReleaseYear(int releaseYear){this.releaseYear = releaseYear;}

    public void printInformation(){
        System.out.println("-----영화 정보 출력-----");
        System.out.println(">제목 : " + this.title);
        System.out.println(">개봉연도 : " + this.releaseYear);
        System.out.println("----------------------");
    }
}
