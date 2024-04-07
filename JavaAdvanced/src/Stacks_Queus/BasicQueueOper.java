package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] elements = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer>queue = new ArrayDeque<>();
        for (int i = 0; i < array[0]; i++) {
            queue.offer(elements[i]);
        }

        for (int i = 0; i < array[1]; i++) {
            queue.poll();
        }

        if(queue.contains(array[2])) {
            System.out.println("true");
        }else if(queue.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(Collections.min(queue));
        }

    }
}
