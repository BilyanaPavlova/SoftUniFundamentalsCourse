package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis_wrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();


        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        String str1 = str.substring(0, str.length() / 2);
        String str2 = str.substring(str.length() / 2);

//        this way of splitting by 2 works does not work for {}{([])} which is balanced as well

        System.out.println(str1);
        System.out.println(str2);

        for (char ch: str1.toCharArray()) {
            stack.push(ch);
        }

        for (char ch: str2.toCharArray()) {
            queue.offer(ch);
        }



        for (int i = 0; i < str.length() / 2; i++) {
            switch (stack.pop()){
                case '(':
                    if (queue.poll() != ')'){
                        System.out.println("NO");
                        return;
                    }
                    break;
                case '[':
                    if (queue.poll() != ']'){
                        System.out.println("NO");
                        return;
                    }
                    break;
                case '{':
                    if (queue.poll() != '}'){
                        System.out.println("NO");
                        return;
                    }
                    break;
                default:
                    System.out.println("NO");
                    return;

            }

        }

        if(!stack.isEmpty() || !queue.isEmpty()){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
