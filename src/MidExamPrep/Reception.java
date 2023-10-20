package MidExamPrep;

import java.util.Scanner;

public class Reception {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int firstEmEfficiency = Integer.parseInt(sc.nextLine());
            int secondEmEfficiency = Integer.parseInt(sc.nextLine());
            int thirdEmEfficiency = Integer.parseInt(sc.nextLine());
            int students = Integer.parseInt(sc.nextLine());
            int totalEfficiencyPerHour = firstEmEfficiency + secondEmEfficiency + thirdEmEfficiency;
            int hoursPureWork = students / totalEfficiencyPerHour;
            int remainingStudents = students % totalEfficiencyPerHour;

            int hoursBreaks = hoursPureWork / 3;

            double hours = 0;

            if (remainingStudents > 0){
                hours = hoursPureWork + hoursBreaks + 1;
            } else if (remainingStudents == 0){
                hours = hoursPureWork + hoursBreaks ;
            }





            System.out.printf("Time needed: %.0fh.", (hours));
        }

    }


