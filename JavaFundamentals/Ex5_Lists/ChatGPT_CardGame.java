package Ex5_Lists;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ChatGPT_CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input hands as arrays
        int[] firstHand = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondHand = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Create Deque (double-ended queue) for each player
        Deque<Integer> firstPlayerDeck = new ArrayDeque<>();
        Deque<Integer> secondPlayerDeck = new ArrayDeque<>();

        // Add cards to the player's decks
        for (int card : firstHand) {
            firstPlayerDeck.offer(card);
        }
        for (int card : secondHand) {
            secondPlayerDeck.offer(card);
        }

        // Play the card game
        while (!firstPlayerDeck.isEmpty() && !secondPlayerDeck.isEmpty()) {
            int firstPlayerCard = firstPlayerDeck.poll();
            int secondPlayerCard = secondPlayerDeck.poll();

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.offer(firstPlayerCard);
                firstPlayerDeck.offer(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.offer(secondPlayerCard);
                secondPlayerDeck.offer(firstPlayerCard);
            }
        }

        // Determine the winner and print the result
        if (firstPlayerDeck.isEmpty()) {
            int sum = secondPlayerDeck.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            int sum = firstPlayerDeck.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }
}
