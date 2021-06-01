import java.util.Scanner;

public class Myapp {
    public static void main(String [] args) {
        System.out.println("== start ==");
        Scanner scan = new Scanner(System.in);
        int i;

        while (true) {
            System.out.println("--------");
            System.out.println("1. 카드 뽑기");
            System.out.println("2. 종료");
            System.out.println("--------");

            System.out.print(">");
            i = scan.nextInt();

            if (i == 1) {
                selectOne();
            } else if (i == 2) {
                System.out.println("==end==");
                break;
            } else {
                System.out.println("Wrong input, try again");
            }
        }
    }

        public static void selectOne(){
            int randNumber = (int)(Math.random() * 13)+1; //1~13
            final String[] kind = {"Herat", "Spade", "Club", "Diamaon"};
            int randInx = (int)(Math.random() * 4);

            Card card = new Card(kind[randInx], randNumber);
            card.printCard();
        }
}

