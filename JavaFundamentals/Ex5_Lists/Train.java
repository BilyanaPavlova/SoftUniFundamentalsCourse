package Ex5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> train = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int capacity = Integer.parseInt(sc.nextLine());

        String command = sc.nextLine();

        while (!command.equals("end")) {
            String[] com = command.split(" ");

            if (command.contains("Add")) {

                int passengers = Integer.parseInt(com[1]);
                train.add(passengers);

            } else {
                int passengers = Integer.parseInt(com[0]);
                for (int wagon : train) {
                    int idx = train.indexOf(wagon);
                    if (capacity - wagon >= passengers) {
                        train.set(idx, wagon + passengers);
                        break;
                    }
                }

            }


            command = sc.nextLine();
        }

//        for (int wagon :
//                train) {
//            System.out.print(wagon + " ");
//        }


        System.out.println(String.join(" ", train.stream().map(String::valueOf).collect(Collectors.toList())));
    }
}
