package exam.febr_17_24.task01;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;
import java.util.stream.Collectors;

public class ChickenSnack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> coins = new Stack<>();
        coins.addAll(Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList());

        Queue<Integer> prices = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        int counter = 0;
        while (true) {
            if (coins.isEmpty() || prices.isEmpty()) {
                printResult(counter);
                return;
            }

            int amount = coins.peek();
            int price = prices.peek();

            int diff = amount - price;


            if (diff == 0) {
                coins.pop();
                prices.poll();
                counter++;
            } else if (diff > 0) {
                coins.pop();
                if (!coins.isEmpty()) {
                    int previous = coins.pop();
                    int toAdd = previous + diff;
                    coins.push(toAdd);
                }
                prices.poll();
                counter++;
            } else {
                coins.pop();
                prices.poll();
            }
        }
    }

    public static void printResult(int counter) {
        if (counter >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.", counter);
        } else if (counter > 1) {
            System.out.printf("Henry ate: %d foods.", counter);
        } else if (counter == 1) {
            System.out.println("Henry ate: 1 food.");
        } else {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
    }
}
