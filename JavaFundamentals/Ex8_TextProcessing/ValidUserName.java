package Ex8_TextProcessing;

import java.util.Scanner;

public class ValidUserName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] input = sc.nextLine().split(", ");

        for (int i = 0; i < input.length; i++) {
            if(input[i].length() >= 3 && input[i].length() <= 16 && isValidInput(input[i])){
                System.out.println(input[i]);
            }
        }


    }

    public static boolean isValidInput (String word){
        for (char ch : word.toCharArray()) {
            if(!Character.isLetterOrDigit(ch)) {
                if(ch == '-' || ch == '_') {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
