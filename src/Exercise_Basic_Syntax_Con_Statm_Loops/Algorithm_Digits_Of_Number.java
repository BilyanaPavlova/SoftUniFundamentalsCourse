package Exercise_Basic_Syntax_Con_Statm_Loops;

import java.util.Scanner;

public class Algorithm_Digits_Of_Number {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        int number = Integer.parseInt(sc.nextLine());

        while(number > 0){
            int d = number%10;
            number = number/10;
        }
    }
}
