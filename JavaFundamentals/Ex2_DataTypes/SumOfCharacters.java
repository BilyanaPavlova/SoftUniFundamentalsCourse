package Ex2_DataTypes;

import java.util.Scanner;

public class SumOfCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        if (n < 0 && n > 20){
            return;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
           int num = (int) sc.nextLine().charAt(0);
           sum += num;

        }
        System.out.printf("The sum equals: %d", sum);
    }
}
