package Ex7_AssociativeArraya;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> premiumItems = new LinkedHashMap<>();
        premiumItems.put("shards", 0);
        premiumItems.put("fragments", 0);
        premiumItems.put("motes", 0);

        Map<String, Integer> trash = new LinkedHashMap<>();

        String winner = "";

        String[] input = sc.nextLine().split(" ");

        while (true) {

            List<String> list = new ArrayList<>(Arrays.asList(input));


//            for (int i = 0; i <= list.size(); i++) {

            while(!list.isEmpty()){

                String key = list.get(1).toLowerCase();

                boolean premium = key.equals("shards")
                        || key.equals("motes")
                        || key.equals("fragments");

                if (premium) {
                    premiumItems.put(key, premiumItems.get(key) + Integer.parseInt(list.get(0)));
                    if (premiumItems.get(key) >= 250){
                        winner = key;
                        premiumItems.put(winner, premiumItems.get(key) - 250);

                        break;
                    }
                    list.remove(1);
                    list.remove(0);
                    continue;
                }

                if (trash.containsKey(key)) {
                    trash.put(key, trash.get(key) + Integer.parseInt(list.get(0)));
                } else {
                    trash.put(key, Integer.parseInt(list.get(0)));
                }
                list.remove(1);
                list.remove(0);
                continue;

            }

            if (winner.equals("shards")){
                System.out.println("Shadowmourne obtained!");
                printResult(premiumItems, trash);
                return;
            }

            if(winner.equals("fragments")){
                System.out.println("Valanyr obtained!");
                printResult(premiumItems, trash);
                return;
            }

            if(winner.equals("motes")){
                System.out.println("Dragonwrath obtained!");
                printResult(premiumItems, trash);
                return;
            }


            input = sc.nextLine().split(" ");
        }


    }

    public static void printResult(Map<String, Integer> pi, Map<String, Integer> trash){
        pi.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
        trash.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }


}

