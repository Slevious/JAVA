import java.util.Scanner;

public class Myapp {

    public static void main (String [] args) {

        int [][] arr = new int [5][];

        for(int i =0; i<arr.length; i++){
            arr[i] = new int[i+1];
            for(int j = 0; j<arr[i].length;j++){
                arr[i][j] = j;
            }

        }

        for(int i =0; i<arr.length;i++){
            for(int j =0;j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
//        String[] subjectNames = {"영어", "과학", "수학", "사회"};
//        int[][] subjectScores = {{100, 100, 100, 90}, {40, 50, 20, 60}, {50, 50, 50, 50}};
//
//        for(int i = 0; i < subjectScores.length; i++){
//            System.out.println("학생 " + i);
//            for(int j = 0; j<subjectScores[i].length; j++){
//                System.out.println(subjectNames[i] + " 점수 " + subjectScores[i][j]);
//            }
//        }

//        String[] subjectNames = {"국어", "영어", "수학", "사회", "과학"};
//        int[] subjectScores = new int[5];
//        Scanner scan1 = new Scanner(System.in);
//        int score;

//        subjectScores[0] = 100;
//        subjectScores[1] = 50;
//        subjectScores[2] = 10;
//        subjectScores[3] = 70;
//        subjectScores[4] = 80;
//
//        System.out.println(">int 배열의 길이:" + subjectScores.length);
//        for (int i = 0; i < subjectScores.length; i++) {
//            System.out.println(subjectNames[i] + " : " + subjectScores[i]);
//        }
//        System.out.println(subjectNames[3] + "과목 수정, 기존 점수 " + subjectScores[3]);
//        modifyScore(subjectScores, 3);
//        System.out.println(subjectNames[3] + "과목 수정, 수정 후 점수 " + subjectScores[3]);
//
//    }
        public static void modifyScore(int[] score, int index){
            score[index] += 10;
        }
}
