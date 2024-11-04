package task01;

import java.util.*;
import java.util.stream.Collectors;

public class WormsAndHoles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


//        Stack<Integer> stack = new Stack<>();
//
//        String[] worms = sc.nextLine().split("\\s+");
//        for (String worm : worms) {
//            stack.push(Integer.parseInt(worm));
//        }

        //read stack
        Stack<Integer> stack = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Stack::new, Stack::push, Stack::addAll);


        // Example usage: print the stack
//        System.out.println(stack.peek());

        //read queue
        Queue<Integer> queue = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);


//        System.out.println(queue.peek());

        int eliminatedWorms = 0;
        int matches = 0;

        while (!stack.isEmpty() && !queue.isEmpty()) {

            int lastWorm = stack.peek();
            int firstHole = queue.peek();

            if (lastWorm == firstHole) {
                stack.pop();
                queue.poll();
                matches++;
            } else {
                queue.poll();
                lastWorm -= 3;
                stack.pop();
                if (lastWorm > 0) {
                    stack.push(lastWorm);
                } else {
                    eliminatedWorms++;
                }

            }
        }

        if (matches > 0) {
            System.out.printf("Matches: %d\n", matches);
        } else {
            System.out.println("There are no matches.");
        }

        if (stack.isEmpty() && queue.isEmpty()) {
                System.out.println("Every worm found a suitable hole!");
            }

        if (stack.isEmpty() && eliminatedWorms > 0) {
            System.out.println("Worms left: none");
        }


        // print joining with comma
        if (!stack.isEmpty()) {
            String result = stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Worms left: " + result);
        }

        if (queue.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            String result = queue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Holes left: " + result);

        }

    }
}
