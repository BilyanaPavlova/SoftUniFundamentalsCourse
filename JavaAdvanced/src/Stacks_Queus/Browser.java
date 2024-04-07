package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        String previous = "";
        String current = "";


        while (!input.equals("Home")){

            if(input.equals("back")){
                if (stack.isEmpty() || stack.size() == 1){
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    previous = stack.peek();
                        System.out.println(previous);
                    }

                } else {
                System.out.println(input);
                stack.push(input);
                current = stack.peek();
            }

            input = sc.nextLine();
        }
    }
}
