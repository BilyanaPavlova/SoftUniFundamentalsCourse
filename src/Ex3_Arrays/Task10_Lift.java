package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task10_Lift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int people = Integer.parseInt(sc.nextLine());
        int [] cabins = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();


        int totalPeopleInLift = 0;
        boolean isEmptySpace = true;

        while(true) {



            //if there are people and there are empty spots
               if (people > 0 && totalPeopleInLift < cabins.length*4){
                for (int j = 0; j < cabins.length; j++) {
                    // for each cabin
                    int freePlaces = 4 - cabins[j];
                    if (freePlaces == 0) {
                        break; // break and go to the next cabin
                    } else {
                        if (people >= freePlaces) {
                            cabins[j] = cabins[j] + freePlaces; // fill the cabin
                            people = people - freePlaces;
                        } else {
                            cabins[j] = cabins[j] + people;
                            people = 0;
                        }
                    }
                }
            }

            for (int i = 0; i < cabins.length; i++) {
                totalPeopleInLift += cabins[i]; // total number of the people in the lift

            }

                //If the lift is full and there are no more people in the queu
            if(totalPeopleInLift == cabins.length*4 && people == 0){
                    System.out.println(Arrays.toString(cabins)
                            .replace("[", "")
                            .replace("]", ""));
                    return;

            } //If there are no more people and the lift has empty spot
            else if (people == 0 && totalPeopleInLift < cabins.length*4) {
                    System.out.println("The lift has empty spots!");
                    System.out.println(Arrays.toString(cabins)
                            .replace("[", "")
                            .replace("]", ""));
                    return;
            }
//          If there are still people in the queue and no more available space
            else if (people > 0 && totalPeopleInLift == cabins.length*4){
                    System.out.printf("There isn't enough space! %d people in a queue!\n", people);
                    System.out.println(Arrays.toString(cabins)
                            .replace("[", "")
                            .replace("]", ""));
                    return;
            }
        }
    }
}





