package Ex8_TextProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] input = sc.nextLine().split(" ");

        int sum = 0;


        String remainingLetters = "";

        if(input[0].length() < input[1].length()){
            remainingLetters = input[1].substring(input[0].length());
        } else if (input[0].length() > input[1].length()){
            remainingLetters = input[0].substring(input[1].length());
        }

        for (int i = 0; i < remainingLetters.length(); i++) {
            sum += remainingLetters.charAt(i);
        }

        int shorterIdx = Math.min(input[0].length(), input[1].length());

        for (int i = 0; i < shorterIdx; i++) {
            sum += (int)input[0].charAt(i) * (int)input[1].charAt(i);
        }

        System.out.println(sum);







    }
}

