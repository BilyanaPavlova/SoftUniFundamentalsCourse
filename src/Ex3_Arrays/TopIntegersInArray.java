package Ex3_Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TopIntegersInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        boolean isbigger = true;
        for (int i = 0; i < numbers.length; i++) {
            isbigger = true;
            for (int j = i+1; j < numbers.length; j++) {

                if (numbers[i] <= numbers[j]){
                    isbigger = false;
                    break;
                }
            }
            if (isbigger){
                System.out.print(numbers[i] + " ");

            }

        }

    }
}
