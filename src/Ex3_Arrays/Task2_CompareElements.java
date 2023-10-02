package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_CompareElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] first = sc.nextLine().split(" ");
        String[] second = sc.nextLine().split(" ");

        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < first.length; j++) {
                if (second[i].equals(first[j])) {
                    System.out.print(second[i] + " ");
                }
            }
        }
        
    }
}
