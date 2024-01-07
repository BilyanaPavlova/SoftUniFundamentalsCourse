package Lec1_BasicSyntaxConditionalStatementsLoops;

import java.util.Scanner;


public class Task_10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int result;

        for(int i = 1; i <= 10; i++){
            result = number * i;
            System.out.printf("%d X %d = %d%n", number, i, result);
        }
    }
}
