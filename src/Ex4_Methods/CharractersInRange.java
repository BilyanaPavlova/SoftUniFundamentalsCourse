package Ex4_Methods;

import java.util.Scanner;

public class CharractersInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a = sc.nextLine().charAt(0);
        char b = sc.nextLine().charAt(0);
         printRange(a, b);

    }

    public static void printRange (char a, char b) {
        if (a < b) {
            for (int i = a + 1; i < b; i++) {
                System.out.print((char) i + " ");
            }
        }else {
            for (int i = b + 1; i < a; i++) {
                System.out.print((char) i + " ");
            }
        }

    }
}
