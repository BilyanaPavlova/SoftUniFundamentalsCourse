package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;



public class ArrayMofifier2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (true) {
            String command = sc.nextLine();

            if (command.equals("end")) {
                System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
                return;
            }

            if (command.equals("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] - 1;
                }
            }

            if (command.contains("swap")) {
                String[] com = command.split(" ");
                int firstIdx = Integer.parseInt(com[1]);
                int secondIdx = Integer.parseInt(com[2]);

                int temp = numbers[secondIdx];
                numbers[secondIdx] = numbers[firstIdx];
                numbers[firstIdx] = temp;
            }

            if (command.contains("multiply")) {
                String[] com = command.split(" ");
                int firstIdx = Integer.parseInt(com[1]);
                int secondIdx = Integer.parseInt(com[2]);

                int product = numbers[firstIdx] * numbers[secondIdx];
                numbers[firstIdx] = product;

            }
        }



    }
}
