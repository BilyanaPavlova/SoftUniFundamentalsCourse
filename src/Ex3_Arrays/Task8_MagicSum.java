package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task8_MagicSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int num = Integer.parseInt(sc.nextLine());

        //1 7 6 2 19 23
        //
        //8


        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == num){
                    System.out.println(numbers[i] + " " + numbers[j]);
                }
            }
        }
    }
}
