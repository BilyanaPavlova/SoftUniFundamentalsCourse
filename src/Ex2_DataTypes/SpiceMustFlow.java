package Ex2_DataTypes;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int yield = Integer.parseInt(sc.nextLine());
        int days  = 0;
        int totalExtracted = 0;



        while (yield >= 100){


            days += 1;
            totalExtracted += yield - 26;
            yield -= 10;

        }
        System.out.println(days);
        if (totalExtracted >= 26) {
            totalExtracted -= 26;
        }
        System.out.println(totalExtracted);
    }
}
