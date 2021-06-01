import java.util.Scanner;

public class MyApp {

    public static void main (String [] args){

//        String str = "java programming";
//
//        Scanner scan = new Scanner(System.in);
//
//        System.out.print("> ");
//        String input = scan.nextLine();
//
//        if(str.equals(input.trim())){
//            System.out.println("correct");
//        }
//        else {
//            System.out.println("incorrect");
//
//        }
//
//        String result;
//        result = str.equals(input.trim()) ? "correct" : "incorrect";
//        System.out.println(result);
//        Scanner scan = new Scanner(System.in);
//
//        System.out.print(">나이 입력 : ");
//        int i = scan.nextInt();
//
//        switch((i/10)){
//            case 0 :
//                System.out.println("10살 미만입니다.");
//                break;
//            case 1 :
//                System.out.println("10대 입니다.");
//                break;
//            case 2 :
//                System.out.println("20대 입니다.");
//                break;
//            case 3 :
//                System.out.println("30대 입니다.");
//                break;
//            case 4 :
//                System.out.println("40대 입니다.");
//                break;
//            case 5 :
//                System.out.println("50대 입니다.");
//                break;
//            default :
//                System.out.println("60세 이상입니다.");
//        }
        Scanner scan = new Scanner(System.in);

        System.out.print("> ");
        int input = scan.nextInt();
        int i = 1;
//        while(i<=input) {
//            if (i % 2 == 0) {
//                System.out.println(i + "는 짝수입니다.");
//                continue;
//            }
//            else {
//                System.out.println(i + "는 홀수입니다.");
//            }
//            System.out.println("다시");
//            i++;
//        }
        System.out.println("for문 사용");
        int j;
        for(j=1; j<=input; j++) {
            if (j % 2 == 0) {
                System.out.println(j + "는 짝수입니다.");
            }
            else {
                System.out.println(j + "는 홀수입니다.");
                continue;
            }

            System.out.println("다시");
        }


    }
}
