package Lec3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task_7_Condensed {

    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);

    int [] numbers = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    int len = numbers.length;

    if (numbers.length == 1){
             for (int number : numbers) {
                 System.out.println(number);
             }
       return;
        }


    while (len > 1) {

        for (int i = 0; i < len - 1; i++) {
            int num = numbers[i] + numbers[i + 1];
            numbers[i] = num;
            if (len == 2) {
                System.out.print(numbers[i] + " ");
            }
        }

        len --;
    }






    }

}
