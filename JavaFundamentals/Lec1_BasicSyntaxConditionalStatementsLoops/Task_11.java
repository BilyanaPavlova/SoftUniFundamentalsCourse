package Lec1_BasicSyntaxConditionalStatementsLoops;

import java.util.Scanner;


public class Task_11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int multiplier = Integer.parseInt(sc.nextLine());
        int result;

        do {
            result = number * multiplier;
            System.out.printf("%d X %d = %d%n", number, multiplier, result);
            multiplier++;
        } while (multiplier <= 10);


    }
}

