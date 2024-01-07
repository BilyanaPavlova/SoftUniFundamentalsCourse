package ExamPrep_FinalExam;

import java.util.*;

public class Problem3_02_PlantDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, String> plantRarities = new LinkedHashMap<>();
        Map<String, List<Integer>> ratings = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("<->");
            plantRarities.put(input[0], input[1]);
        }

        String command = sc.nextLine();
        while(true){
            if(command.equals("Exhibition")){

                System.out.println("Plants for the exhibition:");
                for (Map.Entry<String, String> entry:
                        plantRarities.entrySet()) {

                    System.out.printf("- %s; Rarity: %s; ", entry.getKey(), entry.getValue());

                    //calculate the average rating
                    int sumRatings = 0;
                    if(!ratings.get(entry.getKey()).equals("0")) {
                        int size = ratings.get(entry.getKey()).size();

                        for (int rate :
                                ratings.get(entry.getKey())) {
                            sumRatings += rate;
                        }
                    }


                    double avRating = sumRatings*1.0/ ratings.get(entry.getKey()).size();
                    System.out.printf("Rating: %.2f\n", avRating);

                }

                return;
            }

            if(command.contains("Rate")){
//  "Rate: {plant} - {rating}" – add the given rating to the plant (store all ratings)
                String plant = (command.split(" - ")[0]).split(": ")[1];
                if(plantRarities.containsKey(plant)) {

                    String rating = command.split(" - ")[1];

                    if (ratings.containsKey(plant)) {
                        ratings.get(plant).add(Integer.parseInt(rating));
                    } else {
                        ratings.put(plant, new ArrayList<>());
                            ratings.get(plant).add(Integer.parseInt(rating));
                        }

                } else {
                    System.out.println("error");
                    command = sc.nextLine();
                    continue;
                }
            }

            if(command.contains("Update")){
//  "Update: {plant} - {new_rarity}" – update the rarity of the plant with the new one
                String plant = (command.split(" - ")[0]).split(": ")[1];
                if (plantRarities.containsKey(plant)) {

                    String newRarity = command.split(" - ")[1];
                    plantRarities.put(plant, newRarity);

                } else {

                    System.out.println("error");
                    command = sc.nextLine();
                    continue;
                }
            }

            if(command.contains("Reset")){
//  "Reset: {plant}" – remove all the ratings of the given plant
                String plant = command.split(": ")[1];

                if (plantRarities.containsKey(plant)) {
                    ratings.replace(plant, new ArrayList<>());

                } else {
                    System.out.println("error");
                    command = sc.nextLine();
                    continue;
                }
            }

            command = sc.nextLine();
        }

    }
}
