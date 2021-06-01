import java.util.Locale;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {

      System.out.println("2020270758 임광민");

      String str = "Hello World!";
      System.out.println(str);

      String input;
      Scanner scan = new Scanner((System.in));

      System.out.println("Lower Case : " + str.toLowerCase());
      System.out.println("Upper case : " + str.toUpperCase());

      str = "hello java programming";
      System.out.println("str length : " + str.length());

      System.out.println(str.charAt(2));
      System.out.println(str.substring(2));
      System.out.println(str.substring(2,8));

      int index = str.indexOf("java");
      System.out.println("\"java\" in str : " + index);
      System.out.println("\"JAVA\" in str " + str.indexOf("JAVA"));

      System.out.println((str.equals("hello java programming")));
      System.out.println((str.equals("hello java Programming")));
      System.out.println(str.equalsIgnoreCase("hello java Programming"));

      System.out.print("> ");
      input = scan.nextLine();
      System.out.println(input + "!");
      System.out.println(str.equals(input));
      System.out.println((str.equals(input.trim())));

    }
}
