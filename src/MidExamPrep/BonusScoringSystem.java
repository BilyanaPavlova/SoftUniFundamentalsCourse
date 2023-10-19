package MidExamPrep;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int students = Integer.parseInt(sc.nextLine());
        int lectures = Integer.parseInt(sc.nextLine());
        int bonus = Integer.parseInt(sc.nextLine());
        int attendancees = 0;
        double totalBonus = 0;
        double temp = 0;
        int studAttendancies = 0;

        for (int i = 1; i <= students; i++) {
            attendancees = Integer.parseInt(sc.nextLine());

//            {total bonus} =
//            {student attendances} / {course lectures} * (5 + {additional bonus})
            totalBonus = (attendancees*1.0/lectures) * (5 + bonus);

            if(totalBonus >= temp){
                temp = totalBonus;
                studAttendancies = attendancees;
            }
        }

        System.out.printf("Max Bonus: %.0f.\n", temp);
        System.out.printf("The student has attended %d lectures.\n", studAttendancies);

    }
}
