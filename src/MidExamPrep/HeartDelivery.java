package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> neighbourhood = Arrays.stream(sc.nextLine().split("\\@"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int lastHouse = 0;
        int valentines = 0;
        String command = sc.nextLine();
        while(!command.equals("Love!")){



            String[] com = command.split(" ");
            int houseToHit = Integer.parseInt(com[1]);
            houseToHit = houseToHit + lastHouse;



            if (houseToHit > neighbourhood.size()-1) {
                houseToHit = 0;
            }

            if (neighbourhood.get(houseToHit) == 0){
                System.out.printf("Place %d already had Valentine's day.\n", houseToHit);
                lastHouse = houseToHit;
                command = sc.nextLine();
                continue;
            }

            int diminishedHearts = neighbourhood.get(houseToHit) - 2;
            neighbourhood.set(houseToHit, diminishedHearts);


            if(neighbourhood.get(houseToHit) == 0) {
                System.out.printf("Place %d has Valentine's day.\n", houseToHit);
                valentines ++;
            }

            lastHouse = houseToHit;
//            System.out.println(lastHouse);

            command = sc.nextLine();

        }

        System.out.printf("Cupid's last position was %d.\n",lastHouse);
        if (valentines == neighbourhood.size()){
            System.out.println("Mission was successful.");
        } else {
            int failed = 0;
            for (int house :
                    neighbourhood) {
                if (house != 0) {
                    failed ++;
                }
            }
            if (failed > 0){
                System.out.printf("Cupid has failed %d places.", failed);
            }
        }






        }
    }

