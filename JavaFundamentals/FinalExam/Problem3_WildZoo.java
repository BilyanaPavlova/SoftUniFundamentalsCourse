package FinalExam;

import java.util.*;

public class Problem3_WildZoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map <String, Integer> animalDaylyFood = new LinkedHashMap<>();
        Map <String, String> animalArea = new LinkedHashMap<>();
        Map <String, List<String>> areaAnimals = new LinkedHashMap<>();

        String input = sc.nextLine();
        while(!input.equals("EndDay")){
            String[] instructions = input.split(":\\s|\\-");
            String command = instructions[0];
            String animal = instructions[1];

            switch (command){
                case "Add":
                    int neededFood = Integer.parseInt(instructions[2]);
                    String area = instructions[3];

                    //fill daily food

                    if (animalDaylyFood.containsKey(animal)){
                        int increasedFood = animalDaylyFood.get(animal) + neededFood;
                        animalDaylyFood.put(animal, increasedFood);
                    }
                    animalDaylyFood.putIfAbsent(animal, neededFood);

                    // area for each animal:
                    animalArea.put(animal, area);

                    // fill the areas with animals
                    if(!areaAnimals.containsKey(area)) {
                        areaAnimals.putIfAbsent(area, new ArrayList<>());
                        areaAnimals.get(area).add(animal);

                    } else {
                        if(!areaAnimals.get(area).contains(animal)){
                            areaAnimals.get(area).add(animal);
                        }
//                        areaAnimals.get(area).stream().forEach(System.out::println);
//                        areaAnimals.keySet().forEach(System.out::println);
                    }

                    break;
                case "Feed":
                    int food = Integer.parseInt(instructions[2]);
                    if(animalDaylyFood.containsKey(animal)){
                        int reducedFood = animalDaylyFood.get(animal) - food;
                        if(reducedFood <= 0){
                            animalDaylyFood.remove(animal);

                            //remove the animal from the area since it is no hungry in the area anymore
                            String areaOfTheAnimal = animalArea.get(animal);
                            areaAnimals.get(areaOfTheAnimal).remove(animal);
                            if(areaAnimals.get(areaOfTheAnimal).isEmpty()){
                                areaAnimals.remove(areaOfTheAnimal);
                            }

                            System.out.printf("%s was successfully fed\n", animal);
                        }else{
                            animalDaylyFood.put(animal, reducedFood);
                        }
                    }

                    break;
            }



            input= sc.nextLine();
        }

        System.out.println("Animals:");
        animalDaylyFood.entrySet().forEach(entry -> {
            System.out.printf(" %s -> %dg\n", entry.getKey(), entry.getValue());
        });

        System.out.println("Areas with hungry animals:");
        areaAnimals.entrySet().forEach(entry ->{
            System.out.printf(" %s: %d\n", entry.getKey(), entry.getValue().size());
        });
    }
}
