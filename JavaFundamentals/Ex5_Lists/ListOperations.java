package Ex5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> line = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = sc.nextLine();
        boolean isInvalid = false;
        int countInvalid = 0;

        while (!command.equals("End")) {
            String[] com = command.split(" ");
            if (com[0].equals("Add")) {
                int num = Integer.parseInt(com[1]);
                line.add(num);


            } else if (com[0].equals("Insert")) {
                int num = Integer.parseInt(com[1]);
                int idx = Integer.parseInt(com[2]);
                if(isInBounds(idx, line)) {
                    line.add(idx, num);
                }else {
                    countInvalid++;

                }

            } else if (com[0].equals("Remove")) {
                int idx = Integer.parseInt(com[1]);
                if(isInBounds(idx, line)) {
                    line.remove(idx);
                }else {
                    countInvalid++;
                }


            } else if (com[1].equals("left")) {
                int count = Integer.parseInt(com[2]);
                for (int i = 1; i <= count; i++) {
                    line.add(line.get(0));
                    line.remove(line.get(0));
                }

            } else if (com[1].equals("right")) {
                int count = Integer.parseInt(com[2]);
                for (int i = 1; i <= count; i++) {
                    line.add(0, line.get(line.size() - 1));
                    line.remove(line.size() - 1);
                }
            }

            command = sc.nextLine();


        }

        if(countInvalid > 0) {
            for (int i = 1; i <= countInvalid; i++) {
                System.out.println("Invalid index");

            }
            line.forEach(el -> System.out.print(el + " "));
        }else {
            line.forEach(el -> System.out.print(el + " "));
        }

    }

    public static boolean isInBounds(int idx, List <Integer> line){
        return idx >=0 && idx <=line.size()-1;
    }
}
