import java.util.Scanner;

public class qeustion1 {

    public static void main(String[] args){
        System.out.println("== start ==");
        Scanner scan = new Scanner(System.in);
        int i = 0;

        while(true){
            printChoice();
            System.out.print("> ");
            i = scan.nextInt();

            if(i==1){
                select();
                continue;

            }
            else if (i==2){
                System.out.println("== end ==");
                break;
            }
            else {
                System.out.println("Wrong input. try again");
                continue;
            }
        }
    }

    public static void select(){
        final String[] kind = {"Heart", "Spade", "Diamond", "Club"};
        int randNumber1 = (int)(Math.random() * 13) + 1;
        int randKind1 = (int)(Math.random() * 4);
        int randNumber2 = (int)(Math.random() * 13) + 1;
        int randKind2 = (int)(Math.random() * 4);
        Card card = new Card(kind[randKind1], kind[randKind2], randNumber1, randNumber2);
        card.printCard();
        card.printResult();
    }

    public static void printChoice(){
        System.out.println("---------");
        System.out.println("2020270758 임광민");
        System.out.println("1.Game");
        System.out.println("2.종료");
        System.out.println("---------");

    }
}
