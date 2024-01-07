package ExamPrep_MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Groceries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> groceries = Arrays.stream(sc.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("Go Shopping!")) {

            String[] com = command.split(" ");
            String item = com[1];

            if (com[0].equals("Urgent")) {
                if (!doesExist(groceries, item)) {
                    groceries.add(0, item);
                }
            }

            if (com[0].equals("Unnecessary")) {
                if (doesExist(groceries, item)) {
                    groceries.remove(item);
                }
            }

            if (com[0].equals("Correct")) {
                if (doesExist(groceries, item)) {
                    String newItem = com[2];
                    int idx = groceries.indexOf(item);
                    groceries.set(idx, newItem);
                }
            }

            if (com[0].equals("Rearrange")) {
                if (doesExist(groceries, item)) {
                    int idx = groceries.indexOf(item);
                    groceries.add(item);
                    groceries.remove(idx);
                }
            }




                command = sc.nextLine();


            }
            System.out.println(String.join(", ", groceries));


        }


    public static boolean doesExist(List<String> groceries, String item) {
//        for (int i = 0; i < groceries.size()-1; i++) {
//            if (item.equals(groceries.get(i))){
        if (groceries.contains(item)) {
            return true;
        } else {
            return false;
        }
    }
}