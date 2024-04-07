package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato_Queue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<String> queue = new ArrayDeque<>();

        String[] arr = sc.nextLine().split("\\s+");
        Collections.addAll(queue, arr);
//        System.out.println(queue);

        int n = Integer.parseInt(sc.nextLine());

        while(queue.size() > 1){

            // move the top kid to the rear, simulating passing the potato
            for(int i = 1; i <= n; i++){
                if (i == n){
                    System.out.println("Removed " + queue.poll());
                }else {
                    queue.add(queue.poll());
                }

            }
        }
        System.out.println("Last is " + queue.poll());


        }


}
