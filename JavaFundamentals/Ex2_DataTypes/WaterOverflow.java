package Ex2_DataTypes;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int capacity = 255;
        int totalLitres = 0;

        for (int i = 0; i < n; i++) {
            int newQuantity = Integer.parseInt(sc.nextLine());
            if (newQuantity <= capacity) {
                capacity = capacity - newQuantity;
                totalLitres += newQuantity;

            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(totalLitres);

    }
}
