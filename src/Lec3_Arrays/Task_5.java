package Lec3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                sumOdd += numbers[i];
            } else {
                sumEven += numbers[i];
            }
        }
        System.out.println(sumEven - sumOdd);



    }
}
