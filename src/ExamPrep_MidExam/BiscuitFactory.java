package ExamPrep_MidExam;

import java.util.Scanner;

public class BiscuitFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bPerWorkerPerDay = Integer.parseInt(sc.nextLine());
        int countWorkers = Integer.parseInt(sc.nextLine());
        int bCompetitor30days = Integer.parseInt(sc.nextLine()); // 30 days

        int bDay = bPerWorkerPerDay * countWorkers; //daily factory prod

        double sumB30days = 0;
        for (int i = 1; i <= 30 ; i++) {
            if(i % 3 == 0){
                sumB30days += Math.floor(bDay * 0.75);
            } else {
                sumB30days += bDay;
            }
        }

        System.out.printf("You have produced %.0f biscuits for the past month.\n", sumB30days);

        double difference = sumB30days - bCompetitor30days;
        double dif = Math.abs((difference * 1.0 / bCompetitor30days) * 100);
        if(difference > 0){
            System.out.printf("You produce %.2f percent more biscuits.", dif);
        } else if (difference < 0){
            System.out.printf("You produce %.2f percent less biscuits.", dif);
        }


    }
}
