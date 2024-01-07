package Ex5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = sc.nextLine();
        List<String> comList = Arrays.stream(command.split("\\s+"))
                .collect(Collectors.toList());
        int num = Integer.parseInt(comList.get(1));

        while (!command.equals("end")){
            comList = Arrays.stream(command.split("\\s+"))
                    .collect(Collectors.toList());
            num = Integer.parseInt(comList.get(1));

            if(command.contains("Delete")){

                for (int i = 0; i <= numbers.size()-1; i++) {
                    int current = numbers.get(i);
                    if(current == num){
                        numbers.remove(i);
                    }
                }

            }
            if(command.contains("Insert")){

                int idx = Integer.parseInt(comList.get(2));
                numbers.add(idx, num);
            }



            command = sc.nextLine();

        }

        List <String> numbersAsStrings = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(" ", numbersAsStrings));

    }
}
