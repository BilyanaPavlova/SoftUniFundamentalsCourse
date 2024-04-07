package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        int sum = 0;

        for (int i = input.length - 1; i >= 0; i --) {
            stack.push(input[i]);
        }


        sum = Integer.valueOf(stack.pop());
        while(!stack.isEmpty()) {

           if (stack.peek().equals("+")){
               stack.pop();
               sum += Integer.valueOf(stack.pop());
           } else if(stack.peek().equals("-")){
               stack.pop();
               sum -= Integer.valueOf(stack.pop());
           }
        }
        System.out.println(sum);
    }
}
