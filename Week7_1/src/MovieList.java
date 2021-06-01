public class MovieList {

    private  Movie[] movies;

    public MovieList(int size){
        movies = new Movie[size];

    }

    public void writeInfo(int index, String title, int releaseYear, double grade){
        movies[index] = new Movie(title, releaseYear, grade);
    }

    public void printInfo(int index){
        movies[index].printInformation();
    }

    public void printAll(){
        System.out.println("---모두 프린트---");
        for(Movie movie: movies){
            movie.printInformation();
        }
    }

    public void findMoive(int year){
        for(Movie movie: movies){
            if(year == movie.getReleasseYear())
            movie.printInformation();
            return;
        }
        System.out.println("해당 연도에 개봉한 영화가 없습니다.");
    }


}
