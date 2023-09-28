package Basic_Syntax_Conditional_Statements_Loops;

import java.util.Scanner;

public class Task_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        boolean isEven = false;
        while (!isEven) {
            number = Integer.parseInt(sc.nextLine());
            if(number % 2 == 0){
                isEven = true;
                System.out.printf("The number is: %d", Math.abs(number));
            } else {
                System.out.println("Please write an even number.");
            }
        }
    }
}