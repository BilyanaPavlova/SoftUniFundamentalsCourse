package ExamPrep_MidExam;

import java.util.Scanner;

public class REceprion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstEmEfficiency = Integer.parseInt(sc.nextLine());
        int secondEmEfficiency = Integer.parseInt(sc.nextLine());
        int thirdEmEfficiency = Integer.parseInt(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        int totalEfficiencyPerHour = firstEmEfficiency + secondEmEfficiency + thirdEmEfficiency;
        double hoursPureWork = Math.ceil(students * 1.0 / totalEfficiencyPerHour);

        double breaks = Math.floor(hoursPureWork / 3);
        double totalHours = hoursPureWork + breaks;


        System.out.printf("Time needed: %.0fh.", (totalHours));
    }

}
