package ExamPrep_MidExam;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        int dailyPlunder = Integer.parseInt(sc.nextLine());
        double expected = Double.parseDouble(sc.nextLine());

        double totalPlunder = 0.0;

        for (int i = 1; i <= days; i++) {
            totalPlunder += dailyPlunder;

            if (i % 3 == 0){
                totalPlunder += dailyPlunder * 0.5;
            }

            if (i % 5 == 0){
                totalPlunder -= totalPlunder * 0.3;
            }

        }

        if (totalPlunder < expected){
            double percentageCollected = (totalPlunder /expected) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.\n",percentageCollected );
        } else {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        }



    }
}
