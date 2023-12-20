package ExamPrep_FinalExam;

import java.util.*;

public class PlantDiscoveryNew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map <String, Integer> plantRarity =new LinkedHashMap<>();
        Map<String, List<Double>> plantRatings = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            plantRarity.put(plant, rarity);
            plantRatings.put(plant, new ArrayList<>());

        }

//        System.out.println(plantRarity);

        String line = sc.nextLine();
        while (true){

            if(line.contains("Exhibition")){

                System.out.println("Plants for the exhibition:");
                plantRarity.entrySet().forEach(entry -> {

                    int currentRarity = entry.getValue();
                    String currentPlant = entry.getKey();

                    System.out.printf("- %s; ", currentPlant);
                    System.out.printf("Rarity: %d; ", currentRarity);

                    List<Double> currentPlantRatings = plantRatings.get(currentPlant);


                        double currentRating = currentPlantRatings.stream().mapToDouble(a -> a) // stream over the list elements, and unwrap each of them from Double to double, and the function returns  same element (a->a)
                                .average() // calculate the average on the doubles
                                .orElse(0); // if the list is empty, and average cannot be returned, returns ).00
                            System.out.printf("Rating: %.2f\n", currentRating);

                }
                    );


                return;
            }

            String plant = line.split(" ")[1];

            if(!plantRarity.containsKey(plant)){
                System.out.println("error");
                line = sc.nextLine();
                continue;
            }

            String command = line.split(" ")[0];

            if(command.equals("Rate:")){
                double rating = Double.parseDouble(line.split(" ")[3]);
                List<Double> ratingList = plantRatings.get(plant);
                ratingList.add(rating);
            }

            if(command.equals("Reset:")){

                List<Double> ratingsList = plantRatings.get(plant);
                ratingsList.clear(); // clears the list
            }

            if(command.equals("Update:")){
                plantRarity.put(plant, Integer.parseInt(line.split(" ")[3]));
            }


            line = sc.nextLine();
        }






        }


}
