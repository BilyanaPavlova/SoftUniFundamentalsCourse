package resources.IMPORTANT;

import java.util.Arrays;

public class RULESArraysWithStreams {
    public static void main(String[] args) {

        int min = Arrays.stream(new int[]{15, 25, 35})
                .min()
                .getAsInt(); //min returns an Optional, that's why getAsInt turns it to int

        System.out.println(min);

        int min1 = Arrays.stream(new int[]{}).min().orElse(2); // 2

        System.out.println(min1);

        int max = Arrays.stream(new int[]{15, 25, 35})
                .max()
                .getAsInt();//min returns an Optional, that's why getAsInt turns it to int

        System.out.println(max);

        //sum() - finds the sum of all elements in a collection:
        int sum = Arrays.stream(new int[]{15, 25, 35})
                .sum();
        System.out.println(sum);

        //average() - finds the average of all elements:
        double avg = Arrays.stream(new int[]{15, 25, 35, 17, 45, 89})
                .average()
                .getAsDouble();
        System.out.println(avg);
    }


}
