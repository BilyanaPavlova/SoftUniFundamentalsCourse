package MidExamPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> items = Arrays.stream(sc.nextLine().split("\\|"))
                        .collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("Yohoho!")) {

            String [] com = command.split(" ");

            if (command.contains("Loot")){

                List<String> loots = Arrays.stream(com)
                        .collect(Collectors.toList()); //Java 13 !!! Softuni's Java

                for (int i = 1; i <= loots.size()-1; i++) {
                    if (!isItemContained(items, loots.get(i))){
                        items.add(0, loots.get(i));
                    }
                }
            }
//            System.out.println(items + "test");

            if (command.contains("Drop")) {

                String idxOfItemToDrop = com[1];
                int idx = Integer.parseInt(idxOfItemToDrop);

                if (idx >= 0 && idx <= items.size() - 1) {
                    items.add(items.get(idx));
                    items.remove(idx);
                }
            }
//            System.out.println(items + "test");

            if (command.contains("Steal")) {

                String count = com[1];
                int toRemove = Integer.parseInt(count);

                if (items.size() < toRemove){
                    toRemove = items.size();
                }

                List<String> removed = new ArrayList<>();

                for (int i = 1; i <= toRemove; i++) {
                    String lastItem = items.get(items.size()-1);
                    items.remove(items.size()-1);
                    removed.add(0, lastItem);
                }

                System.out.println(String.join(", ", removed));
            }



            command = sc.nextLine();
        }

        if (!items.isEmpty()) {
            double averTrGain = 0.0;
            int sumOfLengths = 0;
            for (int i = 0; i <= items.size() - 1; i++) {
                sumOfLengths += items.get(i).length();
            }
            averTrGain = sumOfLengths * 1.0 / items.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.\n", averTrGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }

    }
    public static boolean isItemContained(List<String> items, String item){

        for (String el : items) {
            if (el.equals(item)) {
                return true;
            }
        }
        return  false;
    }
}
