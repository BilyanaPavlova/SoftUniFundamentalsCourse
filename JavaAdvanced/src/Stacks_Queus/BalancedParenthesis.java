package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();

        String s = isBalanced(arr) ? "YES" : "NO";

        System.out.println(s);

    }

    public static boolean isBalanced(char[] arr){

        ArrayDeque <Character> openPar = new ArrayDeque<>();
        ArrayDeque <Character> openParStack = new ArrayDeque<>();

        for (char ch :
                arr) {
            switch (ch){

//                {}{([])} - balanced
                // check these cases of close parenthesis:
                case '}':
                    if(openParStack.isEmpty()){
                        return false;
                    }

                    char chara = openParStack.pop();
                    if ('{' != chara){
                        return false;
                    }

                    break;
                case ')':
                    if(openParStack.isEmpty()){
                        return false;
                    }
                    chara = openParStack.pop();
                    if ('(' != chara){
                        return false;
                    }

                    break;
                case ']':
                    if(openParStack.isEmpty()){
                        return false;
                    }
                    chara = openParStack.pop();
                    if ('[' != chara){
                        return false;
                    }

                    break;
                default:
                    // in case it is an open parenthesis:
                    openParStack.push(ch);
            }

        }



        return openParStack.isEmpty(); // isEmpty returns a boolean
    }
}
