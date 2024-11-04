package exam.oct_22_22.task01;

import java.util.*;
import java.util.stream.Collectors;

public class EnergyDrinks {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int[] first = Arrays.stream(sc.nextLine().split(", "))

                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] second = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Stack<Integer> stackCaff = Arrays.stream(first)
                    .boxed()
                    .collect(Collectors.toCollection(Stack::new));


            Queue<Integer> queueDrinks = Arrays.stream(second)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));

            int maxCaf = 300;
            int stamatCaf = 0;


            while(true) {

                if(queueDrinks.isEmpty() || stackCaff.isEmpty()){

                    print(queueDrinks, stamatCaf);
                    return;
                }

                int quantToDrink = (queueDrinks.peek() * stackCaff.peek());

                if ((quantToDrink < maxCaf)) {
                    stamatCaf += quantToDrink;
                    maxCaf -= quantToDrink;
                    queueDrinks.poll();
                    stackCaff.pop();

                } else {
                    stackCaff.pop();
                    queueDrinks.offer(queueDrinks.poll());

                    stamatCaf -= 30;
                    maxCaf -= 30;
                    if (stamatCaf < 0) {

                        print(queueDrinks, stamatCaf);
                        return;

                    }
                }

            }


//        queue.stream().forEach(e -> System.out.print(e + " "));
//        stack.stream().forEach(e -> System.out.print(e + " "));
//
//        System.out.println(queue.poll());
//        System.out.println(stack.pop());

        }

        public static void print(Queue<Integer> drinks, int caff) {

            if(!drinks.isEmpty()) {
                System.out.print("Drinks left: " );
                String queueAsString = drinks.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));

                System.out.println(queueAsString);

            } else {
                System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
            }

            if (caff <= 0) {
                System.out.printf("Stamat is going to sleep with %d mg caffeine.", 0);
            } else {
                System.out.printf("Stamat is going to sleep with %d mg caffeine.", caff);
            }
        }

    }



