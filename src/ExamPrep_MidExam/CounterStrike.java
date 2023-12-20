package ExamPrep_MidExam;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int energy = Integer.parseInt(sc.nextLine());
        int countWon = 0;

        String command = sc.nextLine();
        while(!command.equals("End of battle")){
            if (energy <= 0){
                energy = 0;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWon, energy);
            return;
            }

            int distance = Integer.parseInt(command);
            if(energy < distance){
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWon, energy);
                return;
            }
            energy -= distance;
            countWon ++;
            if (countWon % 3 == 0){
                energy += countWon;
            }

            command = sc.nextLine();

        }

        System.out.printf("Won battles: %d. Energy left: %d", countWon, energy);

    }
}
