package Lec8_Strings;

import java.util.Arrays;
import java.util.Scanner;

public class Lab_RepeatStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                sb.append(input[i]);
            }
        }

        System.out.println(sb.toString());

    }
}
