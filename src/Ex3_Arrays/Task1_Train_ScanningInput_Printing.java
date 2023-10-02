package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task1_Train_ScanningInput_Printing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numWagons = Integer.parseInt(sc.nextLine());
        int peopleInWagon = 0;
        int [] wagons = new int[numWagons];
        int sum = 0;

        for (int i = 0; i < numWagons; i++) {
            peopleInWagon = Integer.parseInt(sc.nextLine());
            wagons[i] = peopleInWagon;
            sum += peopleInWagon;
        }

        for (int j = 0; j < numWagons; j++) {
            System.out.print(wagons[j] + " ");

        }
        System.out.println();
        System.out.println(sum);

    }
}
