package exam.april_10_24.task01;

import java.util.*;
import java.util.stream.Collectors;

public class PiePursuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> contestantsQueue = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> pieStack = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        boolean piesOver = false;
        boolean contestantsOver = false;

        while (true) {

            if (piesOver || contestantsOver) {

                printResult(piesOver, contestantsOver, contestantsQueue, pieStack);
                return;
            }

            int contestant = contestantsQueue.peek();
            int pie = pieStack.peek();
            int diff = contestant - pie;

            if (diff == 0) {
                contestantsQueue.poll();
                pieStack.pop();
            } else if (diff > 0) {
                pieStack.pop();
                contestantsQueue.offer(diff);
                contestantsQueue.poll();
            } else {

                diff *= -1;
                if (diff > 1) {
                    pieStack.pop();
                    pieStack.push(diff);

                } else if (diff == 1 && pieStack.size() != 1) {
                   int last = pieStack.pop();
                   int previous = pieStack.pop();
                   pieStack.push(previous + diff);

                }

                contestantsQueue.poll();
            }

            if(contestantsQueue.isEmpty()) {
                contestantsOver = true;
            }
            if (pieStack.isEmpty()) {
                piesOver = true;
            }


        }


    }

    public static void printResult (boolean pies, boolean contestants, Queue<Integer> contest, Stack<Integer> piesS) {
        if (pies && !contestants) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.print("Contestants left: ");
            String joinedContestants = contest.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.print(joinedContestants);

        } else if (pies && contestants) {
            System.out.println("We have a champion!");
        } else if (contestants && !pies) {
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: ");
            String joinedPies = piesS.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.print(joinedPies);

        }
    }

}
