package Ex5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_StringLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> line = Arrays.stream(sc.nextLine().split("\\s+"))
                        .collect(Collectors.toList());

        String command = sc.nextLine();

        while(!command.equals("3:1")){


            if (command.contains("merge")){
                String[] commandArr = command.split(" ");
                int startIndex = Integer.parseInt(commandArr[1]);
                int endIndex = Integer.parseInt(commandArr[2]);

                merge(startIndex, endIndex, line);

                System.out.println(line);

            }
            command = sc.nextLine();

            if (command.contains("divide")){
                String[] commandArr = command.split(" ");
                int index = Integer.parseInt(commandArr[1]);
                int partitions = Integer.parseInt(commandArr[2]);

                String word = line.get(index);

                int wordLen = word.length();
                int lettersPerPartition = word.length() / partitions;
                int remainder = wordLen % partitions;

                for (int i = 0; i < wordLen; i+=lettersPerPartition) {

                        String substring = word.substring(i, i + lettersPerPartition);
                        line.add(substring);

                    }
                System.out.println(line);
                }




//             a b c d e r f
            }

            sc.nextLine();

            }





    public static void merge(int startIndex, int endIndex, List<String> strings){

        if (startIndex < 0){
            startIndex = 0;
        }

        if (endIndex > strings.size()-1){
            endIndex = strings.size() - 1;
        }

        String newMerged = "";
        for (int i = startIndex; i <= endIndex; i++) {
            newMerged += strings.get(i);
        }

        strings.set(startIndex, newMerged);

        for (int i = startIndex+1; i <= endIndex; i++) {
            strings.remove(i);
        }
    }
}
