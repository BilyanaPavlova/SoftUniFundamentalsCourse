package Lec8_Strings;

import java.util.Scanner;

public class DigitsLettersOthers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))){
                digits.append(input.charAt(i));
            } else if(Character.isLetter(input.charAt(i))){
                letters.append(input.charAt(i));
            }else {
                other.append(input.charAt(i));
            }

        }

        System.out.println(digits.toString());
        System.out.println(letters.toString());
        System.out.println(other.toString());
    }
}
