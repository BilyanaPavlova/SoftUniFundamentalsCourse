package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ZIgZag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxIdx = Integer.parseInt(sc.nextLine());

        int [] arr1 = new int[maxIdx];
        int [] arr2 = new int[maxIdx];

        for (int i = 0; i < maxIdx; i++) {

            int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if(i == 0){
                arr1[i] = numbers[0];
                arr2[i] = numbers[1];
                continue;
            } else if(i % 2 != 0){
                arr1[i] = numbers[1];
                arr2[i] = numbers[0];
                continue;
            } else if (i % 2 == 0){
                arr1[i] = numbers[0];
                arr2[i] = numbers[1];
                continue;
            }

        }
        System.out.println(Arrays.toString(arr1).replaceAll("[\\[\\]\\,]", "").trim());
        System.out.println(Arrays.toString(arr2).replaceAll("[\\[\\]\\,]", "").trim());








    }
}
