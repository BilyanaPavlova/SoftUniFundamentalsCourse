package Lec8_Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab_ReverseSTrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();


        while(!input.equals("end")){

            StringBuilder reversed = new StringBuilder();
            for (int i = input.length() - 1; i >= 0; i--) {
                reversed.append(input.charAt(i));
            }

            System.out.print(input + " = ");
            System.out.println(reversed.toString());
            input = sc.nextLine();
        }


    }
}
