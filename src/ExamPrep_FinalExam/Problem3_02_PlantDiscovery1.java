package ExamPrep_FinalExam;

import java.util.*;

public class Problem3_02_PlantDiscovery1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, String> rarities = new LinkedHashMap<>();
        Map<String, List<Integer>> ratings = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String plant = input.split("<->")[0];
            String rarity = input.split("<->")[1];

            rarities.put(plant, rarity);
            ratings.put(plant, new ArrayList<>());
        }

        String com = sc.nextLine();
        while(!com.equals("Exhibition")){
            String command = com.split(" ")[0];
            String plant = com.split(" ")[1];

            if(!ratings.containsKey(plant) && !rarities.containsKey(plant)){
                System.out.println("error");
                com = sc.nextLine();
                continue;
            }

            switch (command){
                case "Rate:":
                    int rating = Integer.parseInt(com.split(" ")[3]);
                    ratings.get(plant).add(rating);

                    break;
                case "Update:":
                    String newRariry = com.split(" ")[3];
                    rarities.put(plant, newRariry);

                    break;
                case "Reset:":
                    ratings.put(plant, new ArrayList<>());

                    break;

            }
            com = sc.nextLine();
        }

//        Plants for the exhibition:
//        - {plant_name1}; Rarity: {rarity}; Rating: {average_rating}
//        - {plant_name2}; Rarity: {rarity}; Rating: {average_rating}

        System.out.println("Plants for the exhibition:");

        //first way of printing
//        ratings.entrySet().forEach(entry -> {
//            System.out.printf("- %s; Rarity: %s; Rating: %.2f\n",
//                    entry.getKey(),
//                    rarities.get(entry.getKey()),
//                    entry.getValue()
//                            .stream()
//                            .mapToInt(Integer::intValue)
//                            .average()
//                            .orElse(0));
//
//        });

        //second way of printing
        for (String plant : ratings.keySet()) {

            String rarity = rarities.get(plant);
            double averRating = ratings.get(plant).stream().mapToInt(Integer::intValue).average().orElse(0);

            System.out.printf("- %s; Rarity: %s; Rating: %.2f\n", plant, rarity, averRating);
        }

    }
}
