import java.util.HashSet;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args){

        // #1 Gen 이용 실행
//        GenStack<Movie> movieGenStack = new GenStack(10);
//
//        movieGenStack.push(new Movie("find me", 2020, 4.5));
//        movieGenStack.push(new Movie("last game", 2008, 4));
//        movieGenStack.push(new Movie("world",2012,3.5));
//
//        while(!movieGenStack.isEmpty())
//            System.out.println(movieGenStack.pop());

        // #2 MyFrame 이용 실행
//        MyFrame myFrame = new MyFrame();
//        myFrame.setVisible(true);

        // #3 HashSet 이용 실행
//            HashSet<String> fruitSet = new HashSet<>();
//            Scanner scan = new Scanner(System.in);
//            fruitSet.add("바나나");
//        fruitSet.add("딸기");
//        fruitSet.add("포도");
//        fruitSet.add("복숭아");
//        fruitSet.add("멜론");
//
//        System.out.println("-- 과일 목록");
//        for(String fruit: fruitSet)
//            System.out.println(fruit);
//
//        System.out.print("> 찾을 과일 이름: ");
//        String name = scan.nextLine();
//        String result = fruitSet.contains(name)? " Found" : " Not found";
//        System.out.println(name + result);


        // #4 HashMap 이용 실행
            Scanner scanner = new Scanner(System.in);
            StudentHashMap studentHashMap = new StudentHashMap();
            while(true){
                System.out.println("1. 학생 목록");
                System.out.println("2. 학생 추가");
                System.out.println("3. 학생 검색");
                System.out.println("4. 종료");
                System.out.print("> ");

                int i = scanner.nextInt();
                if(i==1){
                    studentHashMap.printInformation();
                }
                else if (i==2){
                    studentHashMap.addStudent();;
                }
                else if (i==3){
                    studentHashMap.searchStudent();
                }
                else if(i==4){
                    break;
                }
            }
    }
}
