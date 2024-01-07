package ExamPrep_MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpaceTravel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] route = sc.nextLine().split("\\|\\|"); // string [] a 8||b 9||c 10||Titan
        int fuel = Integer.parseInt(sc.nextLine());
        int ammunition = Integer.parseInt(sc.nextLine());

        for (String com : route) { // com = а 8
            List<String> command = Arrays.stream(com.split(" ")).collect(Collectors.toList());

            if (command.contains("Travel")) {
                int lightYears = Integer.parseInt(command.get(1));
                if (fuel >= lightYears) {
                    fuel -= lightYears;
                    System.out.printf("The spaceship travelled %d light-years.\n", lightYears);
                } else {
                    System.out.println("Mission failed.\n");
                    return;
                }
            }

            if (command.contains("Enemy")) {
                int enemyArmor = Integer.parseInt(command.get(1));
                if (ammunition >= enemyArmor) { //fight
                    ammunition -= enemyArmor;
                    System.out.printf("An enemy with %d armour is defeated.\n", enemyArmor);
                } else {

                    if (fuel > enemyArmor * 2) { //run
                        System.out.printf("An enemy with %d armour is outmaneuvered.\n", enemyArmor);
                    } else {
                        System.out.println("Mission failed.\n");
                        return;
                    }
                }
            }


                if (command.contains("Repair")) {
                    int af = Integer.parseInt(command.get(1));
                    fuel += af;
                    ammunition += 2 * af;
                    System.out.printf("Ammunitions added: %d.\n", 2 * af);
                    System.out.printf("Fuel added: %d.\n", af);

                }

                if (command.contains("Titan")) {
                    System.out.println("You have reached Titan, all passengers are safe.\n");
                    return;
                }


            }

        }
    }

