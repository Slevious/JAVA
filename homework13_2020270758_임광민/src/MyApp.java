import java.util.Scanner;

public class MyApp {

    public static void main(String[] args){

        GenStack<Movie> movieGenStack = new GenStack(3);
        Scanner scan = new Scanner(System.in);

        System.out.println("2020270758 임광민");

        while(true) {
            // System.out.println을 이용해 1,2,3 선택지 출력
            System.out.println("1. push");
            System.out.println("2. all pop");
            System.out.println("3. exit");


            int i = scan.nextInt(); //다음 정수 i를 받아 선택지에 대한 응답
            if (i == 1) {

                scan.nextLine(); //nextLine 오류에 대비한 명령어
                System.out.print("> 영화 제목: ");
                String title = new String(scan.nextLine());
                System.out.print("> 개봉 연도: ");
                Integer year = new Integer(scan.nextInt());
                System.out.print("> 영화 평점: ");
                Double grade = new Double(scan.nextDouble()); //예제에 있는 명령어중 하나를 응용해 다음 double값을 받아 입력. 위도 유사

                try {
                    if (movieGenStack.isFull()) //Full 상태일 때에 true
                        throw new Exception(": 스택이 가득 찼습니다!"); //실행된다.
                }
                catch (Exception e) {
                    e.printStackTrace(); // catch한 에러 출력
                }



                if (movieGenStack.getTop() != (movieGenStack.getStack()).length) { //현재 top과 stack의 총 길이가 같지 않으면
                    movieGenStack.push(new Movie(title, year, grade)); //빈 공간이 있는것으로 보고 입력
                }
            }

            else if (i == 2){
                while(!movieGenStack.isEmpty()) //비어있지 않다면
                System.out.println(movieGenStack.pop()); //모두 출력
                movieGenStack.isEmpty(); //이후 스택을 빈 공간으로 만든다.
            }

            else if (i == 3){
                break; //종료한다.
            }
        }
    }
}
