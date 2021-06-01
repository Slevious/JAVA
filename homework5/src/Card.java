public class Card {
    private String kind1;
    private String kind2;
    private int number1;
    private int number2;



    public Card(String kind1, String kind2, int number1, int number2){
        this.kind1 = kind1;
        this.kind2 = kind2;
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }
    public int getNumber2() {
        return number2;
    }

    public void printCard() {
        System.out.println(this.kind1 + ": " + this.number1);
        System.out.println(this.kind2 + ": " + this.number2);
    }
    public void printResult(){
        if (number1>number2){
            System.out.println(this.kind1 + ": " + number1 + " win!");
        }
        else if (number1<number2){
            System.out.println(this.kind2 + ": " + number2 + " win!");
        }
        else {
            System.out.println("draw");
        }

    }
}
