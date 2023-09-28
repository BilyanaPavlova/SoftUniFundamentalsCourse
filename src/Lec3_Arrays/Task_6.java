package Lec3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task_6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int[] numbers1 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int[] numbers2 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(el -> Integer.parseInt(el))
                .toArray();

        boolean identical = false;
        int sum = 0;

        for (int i = 0; i < numbers1.length; i ++) {
            if(numbers1[i] != numbers2[i]){
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                identical = false;
                break;
            } else {
                identical = true;
                sum += numbers1[i];
            }
        }


        if(identical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
