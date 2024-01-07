package Ex8_TextProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split("\\s+");
//        System.out.println(Arrays.asList(strings));

        double sum = 0;

        for (String str :
                strings) {
//            char[] charArray = str.toCharArray();
//            char firstChar = charArray[0];
//            char lastChar = charArray[charArray.length - 1];


            StringBuilder buildNumber = new StringBuilder(str);


            //get the letters:
            char firstChar = buildNumber.charAt(0);
            char lastChar = buildNumber.charAt(buildNumber.length() - 1);

            //get the number
            buildNumber.deleteCharAt(0);
            buildNumber.deleteCharAt(buildNumber.length() - 1);
            int number = Integer.parseInt(buildNumber.toString());
//            System.out.println(buildNumber);


            double result = 0;

            if(Character.isUpperCase(firstChar)){
                int pos = positionOfLetter(firstChar);
               result +=  number * 1.0/ pos ;

            }else if(Character.isLowerCase(firstChar)){
                int pos = positionOfLetter(firstChar);
                result += number * pos;

            }

            if(Character.isUpperCase(lastChar)){
                int pos = positionOfLetter(lastChar);
                result +=  result - pos;

            }else if(Character.isLowerCase(lastChar)){
                int pos = positionOfLetter(lastChar);
                result +=  result + pos;
            }

            sum += result;

        }

        System.out.println(sum);
    }

    public static int positionOfLetter(char ch){
        int positionOfLetter = 0;
        if(Character.isUpperCase(ch)) {
            //get position in the alphabet of the capital letters: ascii code - 96
            positionOfLetter = (int) ch - 64;
        } else if(Character.isLowerCase(ch)){
            positionOfLetter = (int) ch - 96;
        }
        return positionOfLetter;
    }
}
