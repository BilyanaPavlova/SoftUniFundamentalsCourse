package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task7_LongestSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int count = 0;
        int temp = 0;
        int longestSequenceStartIndex=0;

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                } else {
                    break; // прекъсва и продължава с кода под  него
                }
            }
            if (count > temp) {  // defines the longest and it is always the leftmost
                temp = count;
                longestSequenceStartIndex = i;

            }
            count = 0;
        }
        for (int k = longestSequenceStartIndex; k <= longestSequenceStartIndex + temp; k++) {
            System.out.print(numbers[k] + " ");
        }

    }
}
