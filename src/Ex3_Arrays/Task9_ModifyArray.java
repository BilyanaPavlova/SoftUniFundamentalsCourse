package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task9_ModifyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int temp = 0;

        int firstIndex = 0;
        int secondIndex = 0;
        while (true) {
            String command = sc.nextLine();
            
            if (command.contains("swap")) {
                String[] s = command.split(" ");
                firstIndex = Integer.parseInt(s[1]);
                secondIndex = Integer.parseInt(s[2]);
                temp = numbers[firstIndex];
                numbers[firstIndex] = numbers[secondIndex];
                numbers[secondIndex] = temp;
//                System.out.println(Arrays.toString(numbers)
//                        .replace("[", "")
//                        .replace("]", ""));

            }

            if (command.contains("multiply")) {
                String[] s = command.split(" ");
                firstIndex = Integer.parseInt(s[1]);
                secondIndex = Integer.parseInt(s[2]);
                int product = numbers[firstIndex] * numbers[secondIndex];
                numbers[firstIndex] = product;
//                System.out.println(Arrays.toString(numbers)
//                        .replace("[", "")
//                        .replace("]", ""));

            }

            if (command.contains("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] --;
                }
//                System.out.println(Arrays.toString(numbers)
//                        .replace("[", "")
//                        .replace("]", ""));
            }

            if (command.contains("end")) {
                System.out.println(Arrays.toString(numbers)
                        .replace("[", "")
                        .replace("]", ""));
                return;
            }

        }
    }
}
