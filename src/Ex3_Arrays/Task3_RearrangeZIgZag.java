package Ex3_Arrays;

import java.util.Scanner;

public class Task3_RearrangeZIgZag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] firstArr = new String[n];
        String [] secondArr = new String[n];;
        String [] numbers = new String[2];;
        for (int i = 0; i < n; i++){
             numbers = sc.nextLine().split(" ");
            if (i % 2 == 0){
                firstArr[i] = numbers[0];
                secondArr[i] = numbers[1];
            } else {
                firstArr[i] = numbers[1];
                secondArr[i] = numbers[0];
            }
        }
        for (int i = 0; i < n; i++){
            System.out.print(firstArr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++){
            System.out.print(secondArr[i] + " ");
        }

    }
}
