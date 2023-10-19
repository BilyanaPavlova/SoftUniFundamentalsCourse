package Ex5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCommands = Integer.parseInt(sc.nextLine());
        List<String> guests = new ArrayList<>();
        List<String> notInTheList = new ArrayList<>();
        List<String> alreadyIn = new ArrayList<>();

        String guest = "";
        int count = 1;

        while (count <= numCommands) {

            String commandLine = sc.nextLine();

            String[] command = commandLine.split("\\s");
            List<String> comList = new ArrayList<>(Arrays.asList(command));
            guest = comList.get(0);

            //is going
            if (commandLine.contains("is going")) {

                if (!guests.contains(guest)) {
                    guests.add(guest);

                } else {
//                    System.out.printf("%s is already in the list!\n", guest);
                    if(!alreadyIn.contains(guest)) {
                        alreadyIn.add(guest);
                    }
                }
                // is not going
            } else if (commandLine.contains("is not going")){
                if (!guests.contains(guest)) {
                    if(!notInTheList.contains(guest)) {
                        notInTheList.add(guest);
                    }

                } else {
                    guests.remove(guest);

                }
            }
            count++;
        }

        if (!notInTheList.isEmpty()) {
            for (int i = 0; i < notInTheList.size(); i++) {
                String name = notInTheList.get(i);
                System.out.printf("%s is not in the list!\n", name);
            }
        }
        if (!alreadyIn.isEmpty()) {
            for (int i = 0; i < alreadyIn.size(); i++) {
                String name = alreadyIn.get(i);
                System.out.printf("%s is already in the list!\n", name);
            }
        }

        for (String el : guests) {
            System.out.println(el + " ");
        }

    }
}

