import java.util.Scanner;

public class question1 {

    public static void main(String[] args) {

        System.out.println("2020270758 임광민");
        Scanner scan = new Scanner(System.in);

        System.out.print(">");
        String input = "";
        String output = "";

        input = scan.nextLine();
        int temp;

        for (int i = 0; i < input.length(); i++) {
            temp = input.charAt(i);

            if ((temp >= 65) && (temp <= 90)) {
                System.out.print((char)(temp+32));
            }
            else if ((temp >= 97) && (temp <= 122)){
                System.out.print((char)(temp-32));
            }
            else{
                System.out.print((char)(temp));
            }
        }
    }
}
