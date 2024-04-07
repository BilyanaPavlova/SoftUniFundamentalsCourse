package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < array[0]; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < array[1]; i++) {
            stack.pop();
        }

        if(stack.contains(array[2])){
            System.out.println("true");
        } else if(stack.isEmpty()) {
            System.out.println(0);
        }else {
            System.out.println(Collections.min(stack));
        }

    }
}
