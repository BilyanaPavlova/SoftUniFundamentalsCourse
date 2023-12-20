package ExamPrep_MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(sc.nextLine().split(">"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(sc.nextLine().split(">"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

       int maxHealth = Integer.parseInt(sc.nextLine());

       String command = sc.nextLine();

       while(true){

           String [] com = command.split(" ");

           if (command.contains("Fire")){
               int idx = Integer.parseInt(com[1]);
               int damage = Integer.parseInt(com[2]);

               if(idx >= 0 && idx <= warShip.size()-1){
                  warShip.set(idx, warShip.get(idx) - damage);
                  if (warShip.get(idx) <= 0){
                      System.out.println("You won! The enemy ship has sunken.\n");
                      return;
                  }
               }
           }

           if (command.contains("Defend")){
               int startIdx = Integer.parseInt(com[1]);
               int endIdx = Integer.parseInt(com[2]);
               int damage = Integer.parseInt(com[3]);

               if (startIdx >= 0 && startIdx <= pirateShip.size()-1 && endIdx>=0 && endIdx <= pirateShip.size()-1) {
                   for (int i = startIdx; i <= endIdx; i++) {
                       pirateShip.set(i, pirateShip.get(i) - damage);

                       if (pirateShip.get(i) <= 0){
                           System.out.println("You lost! The pirate ship has sunken.\n");
                           return;
                       }
                   }
               }
           }

           if (command.contains("Repair")){
               int idx = Integer.parseInt(com[1]);
               int health = Integer.parseInt(com[2]);

               if(idx >= 0 && idx <= pirateShip.size()-1) {
                   pirateShip.set(idx, pirateShip.get(idx) + health);
                   if (pirateShip.get(idx) > maxHealth){
                   pirateShip.set(idx, maxHealth);
                   }
               }
           }

           if (command.contains("Status")){
               int count = 0;
               for (int i = 0; i <= pirateShip.size()-1; i++) {
                   if (pirateShip.get(i) < maxHealth * 0.2)
                       count ++;
               }
               System.out.printf("%d sections need repair.\n", count);
           }

           if (command.contains("Retire")){
               int sumPirate = 0;
               for (int i = 0; i <= pirateShip.size()-1; i++) {
                   sumPirate += pirateShip.get(i);
               }

               int sumWar = 0;
               for (int i = 0; i <= warShip.size()-1; i++) {
                   sumWar += warShip.get(i);
               }

               System.out.printf("Pirate ship status: %d\n", sumPirate);
               System.out.printf("Warship status: %d\n", sumWar);
               return;
           }

           command = sc.nextLine();
       }




    }
}
