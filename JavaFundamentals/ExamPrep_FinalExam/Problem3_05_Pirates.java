package ExamPrep_FinalExam;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem3_05_Pirates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map <String, Integer> cityPop = new LinkedHashMap<>();
        Map <String, Integer> cityGold = new LinkedHashMap<>();

        String input = sc.nextLine();
        while(!input.equals("Sail")){

            String city = input.split("\\|\\|")[0];
            int pop = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);

            if(cityPop.containsKey(city) && cityGold.containsKey(city)){
                int newPop = cityPop.get(city) + pop;
                int newGold = cityGold.get(city) + gold;
                cityPop.put(city, newPop);
                cityGold.put(city, newGold);
            }

            cityPop.putIfAbsent(city, pop);
            cityGold.putIfAbsent(city, gold);

            input = sc.nextLine();

        }

        String input2 = sc.nextLine();
        while(!input2.equals("End")){

            String command = input2.split("=>")[0];
            String city = input2.split("=>")[1];

            if(command.equals("Plunder")) {
                int killed = Integer.parseInt(input2.split("=>")[2]);
                int plundered = Integer.parseInt(input2.split("=>")[3]);

                cityPop.put(city, cityPop.get(city) - killed);
                cityGold.put(city, cityGold.get(city) - plundered);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",
                        city, plundered, killed);

                if(cityPop.get(city) <=0 || cityGold.get(city) <= 0){
                    cityPop.remove(city);
                    cityGold.remove(city);
                    System.out.printf("%s has been wiped off the map!\n", city);
                }
            }

            if(command.equals("Prosper")) {

                int increaseInGold = Integer.parseInt(input2.split("=>")[2]);
                if(increaseInGold <= 0){
                    System.out.println("Gold added cannot be a negative number!");
                    input2 = sc.nextLine();
                    continue;
                }

                cityGold.put(city, cityGold.get(city) + increaseInGold);
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",
                        increaseInGold, city, cityGold.get(city));


            }


            input2 = sc.nextLine();
        }

        if(!cityPop.isEmpty() && !cityGold.isEmpty()){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", cityPop.size());

//            {town1} -> Population: {people} citizens, Gold: {gold} kg

            cityPop.entrySet().forEach(entry ->
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",
                            entry.getKey(), entry.getValue(), cityGold.get(entry.getKey())));

        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
