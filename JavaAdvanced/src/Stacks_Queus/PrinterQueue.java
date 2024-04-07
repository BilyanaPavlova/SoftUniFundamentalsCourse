package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Deque<String> queue = new ArrayDeque<>();

        while(!input.equals("print")){
            if (input.equals("cancel")){
                if(queue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {

                    System.out.println("Canceled " + queue.poll());
                }
            } else {
                queue.offer(input);
            }
            input = sc.nextLine();
        }

        for (String el :
                queue) {
            System.out.println(el);
        }

    }
}
