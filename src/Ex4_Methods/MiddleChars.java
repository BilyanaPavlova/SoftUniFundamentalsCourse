package Ex4_Methods;

import java.util.Scanner;

public class MiddleChars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        printMiddleChars(text);
    }

    public static void printMiddleChars(String text){
        if (text.length() % 2 == 0) {
            System.out.print(text.charAt(text.length() / 2 - 1));
            System.out.println(text.charAt(text.length() / 2));
        } else {
            System.out.println(text.charAt(text.length() / 2 ));
        }
    }
}
