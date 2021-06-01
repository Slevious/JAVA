public class Theater {

    private int row;
    private int col;
    private int remainingSeat;
    private Movie movie;
    private boolean [][] seats;


    public Theater(int row, int col){
        this.row = row;
        this.col = col;
        this.remainingSeat = remainingSeat;
        this.seats = new boolean[row][col];
        initializeSeats();
    }

    public void initializeSeats(){
        for(int i =0; i<seats.length; i++){
            for(int j =0; j<seats[i].length; j++){
                seats[i][j] = false;
            }
        }
    }

    public void setMovie(Movie movie){this.movie = movie;}

    public void book(int row, int col){
        if(row >= seats.length || col >=seats[0].length){
            System.out.println("잘못된 입력입니다.");
            return;
        }
        if(seats[row][col]){
        System.out.println("이미 예매된 좌석입니다!");
        }
        else{
        System.out.println("예매 완료");
        this.remainingSeat--;
        seats[row][col] = true;
        }
    }

    public void printSeats(){
    movie.printInformation();
    System.out.println("\t\t " + this.remainingSeat + " / " + (this.col * this.row));
    for(int i =0; i<seats.length;i++){
        System.out.print("[#] ");
        for(int j =0; j<seats[i].length; j++){
            if(seats[i][j]){
                System.out.print("[X]");
            }
            else{
                System.out.print("[_]");
            }
        }
        System.out.println(" [#]");
    }
    }
}