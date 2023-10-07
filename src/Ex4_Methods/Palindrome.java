package Ex4_Methods;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        while(!command.equals("END")){
            System.out.println(isPalindrome(command));
            command = sc.nextLine();
        }


    }

    // P e s h o
    // P e s h
    // 0 1 2 3 4
    // 5 / 2 = 2

    public static boolean isPalindrome (String num){
        boolean isPal = true;
        for (int i = 0; i < num.length()/2; i++) {
            if(num.charAt(i) != num.charAt(num.length()-1-i))
                    isPal = false;
                }
        return isPal;
            }

        }



