package Ex4_Methods;

import java.util.Scanner;

public class PassValidator_ReadingStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String password = sc.nextLine();

        checkPassword(password);
    }

    public static void checkPassword(String password){
        if (!checkNumberOfCharacters(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!checkForSpecialCharacters(password)){
            System.out.println("Password must consist only of letters and digits");
        }
        if(!checkForDigits(password)){
            System.out.println("Password must have at least 2 digits");
        }

        if(checkNumberOfCharacters(password)
        && checkForSpecialCharacters(password)
        && checkForDigits(password)) {
            System.out.println("Password is valid");
        }

    }

    public static boolean checkNumberOfCharacters(String password){
        if (password.length() > 5 && password.length() <11){
            return true;
        }
        return false;
    }

    public static boolean checkForSpecialCharacters(String password){
        for (char character: password.toCharArray()) {
            if (character < 48
                    || (character > 57 && character < 65)
                    || (character > 90 && character < 97)
                    || character > 122){
                return false;
            }
        }
        return true;
    }

    public static boolean checkForDigits(String password){
        for (char character: password.toCharArray()) {
            if (character >47 && character < 58){
                return true;
            }
        }
        return false;
    }
}
