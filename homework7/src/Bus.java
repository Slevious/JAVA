public class Bus {

    private int row;
    private int col;
    private int remainingSeat;
    private Bus bus;
    private boolean [][] seats;


    public Bus(int row, int col){
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

    public void setBus(Bus bus){this.bus = bus;}

    public void book(int row, int col){
        if(row >= seats.length || col >=seats[0].length){
            System.out.print("잘못된 입력입니다.");
            return;
        }
        if(seats[row][col]){
            System.out.print("이미 예약된 좌석입니다!");
        }
        else{
            System.out.println("예매 완료\n");
            this.remainingSeat--;
            printSeats();
            System.out.print("> 예매하고 싶은 좌석 입력(-1 입력시 종료): ");
            seats[row][col] = true;
        }
    }

    public void printSeats(){
        System.out.println("  ---- 버스 좌석 ----");
        System.out.println("\t\t" + (40+this.remainingSeat) + " / " + (this.col * this.row));
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