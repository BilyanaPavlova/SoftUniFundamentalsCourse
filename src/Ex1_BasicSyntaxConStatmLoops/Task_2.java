package Ex1_BasicSyntaxConStatmLoops;

import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        if (number % 10 == 0) {
            System.out.printf("The number is divisible by %d%n", 10);
        }else if (number % 42 == 0) {
            System.out.printf("The number is divisible by %d%n", 7);
        } else if (number % 7 == 0) {
            System.out.printf("The number is divisible by %d%n", 7);
        } else if (number % 6 == 0) {
            System.out.printf("The number is divisible by %d%n", 6);
        } else if (number % 3 == 0) {
            System.out.printf("The number is divisible by %d%n", 3);
        }else if (number % 2 == 0) {
            System.out.printf("The number is divisible by %d%n", 2);
        }else {
            System.out.println("Not divisible");
        }

    }
}
