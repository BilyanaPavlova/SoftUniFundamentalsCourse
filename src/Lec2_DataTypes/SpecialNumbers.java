package Lec2_DataTypes;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //specialNum - sum of digits = 5, 7, or 11

        int startNumber = Integer.parseInt(sc.nextLine());
        int sum = 0;

        int number = startNumber;

        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        boolean isSpecial = (sum == 5 || sum == 7 || sum == 11);
        if (isSpecial){
            System.out.println(startNumber + " is special");
        }

    }
}
