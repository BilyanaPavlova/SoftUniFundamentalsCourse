package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task6_EqualSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        //1 2 3 3
        int leftSum = 0;
        int rightSum = 0;
        boolean foundNumber = false;
        for (int i = 0; i < numbers.length; i++) {

            for (int j = i+1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }
            for (int k = i; k >= 0 ; k--) {
                if(k != 0) {
                    leftSum += numbers[k - 1];
                }

            }

            if (leftSum == rightSum){
                foundNumber = true;
                System.out.println(i);
            }

            leftSum = 0;
            rightSum = 0;
        }
        if (!foundNumber){
            System.out.println("no");
        }


    }
}
