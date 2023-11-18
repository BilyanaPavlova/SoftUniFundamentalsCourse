package Ex8_TextProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringExplosions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();

        //abv>1>1>2>2asdasd

//        StringBuilder result = new StringBuilder();
//        int strength = 0;
//        char[]chars = st.toCharArray();
//
//        for (int i = 0; i < chars.length; i++) {
//            char currentChar = st.charAt(i);
//            if (currentChar == '>') {
//                // Found an explosion, read its strength
//                strength += Character.getNumericValue(st.charAt(i+1));
//                result.append(currentChar); // Append the '>'
//            } else if (strength == 0) {
//                // If strength is zero, append the character
//                result.append(currentChar);
//            } else {
//                // Decrease strength and skip the character
//                strength--;
//            }
//        }
//
//        System.out.println(result.toString());
//    }

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //"abv>1>1>2>2asdasd"
        StringBuilder text = new StringBuilder(input);

        int totalStrength = 0; //сила
        for (int position = 0; position < text.length(); position++) {
            char currentSymbol = text.charAt(position);
            if (currentSymbol == '>') {
                //char ('1') -> string ("1") -> int (1)
                //атака
                int attackStrength = Integer.parseInt(text.charAt(position + 1) + ""); //сила на атаката
                totalStrength += attackStrength;
            } else if (currentSymbol != '>' && totalStrength > 0) {
                //премахване
                text.deleteCharAt(position);
                totalStrength--;
                position--;

            }
        }
        System.out.println(text);
    }
}














