package exam.oct_17_22.task01;

import java.util.stream.Collectors;

import java.util.*;

public class task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] first = Arrays.stream(sc.nextLine().split("\\s+"))

                .mapToInt(Integer::parseInt)
                .toArray();

        int[] second = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        Queue<Integer> queue = Arrays.stream(first)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        Stack<Integer> stack = Arrays.stream(second)
                .boxed()
                .collect(Collectors.toCollection(Stack::new));

        List<Integer> claimed = new ArrayList<>();

        while(true) {

            if(queue.isEmpty()){
                System.out.println("First lootbox is empty");
                printSum(claimed);
                return;
            }

            if(stack.isEmpty()){
                System.out.println("Second lootbox is empty");
                printSum(claimed);
                return;
            }


            int num = queue.peek() + stack.peek();

           if ((num % 2 == 0)) {
               claimed.add(num);
               queue.poll();
               stack.pop();

           } else {
               queue.offer(stack.pop());
           }

        }


//        queue.stream().forEach(e -> System.out.print(e + " "));
//        stack.stream().forEach(e -> System.out.print(e + " "));
//
//        System.out.println(queue.poll());
//        System.out.println(stack.pop());

    }

    public static void printSum(List<Integer> claimed) {

        int sum = claimed.stream().reduce(0, Integer::sum);
        if(sum >= 0) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }
}
