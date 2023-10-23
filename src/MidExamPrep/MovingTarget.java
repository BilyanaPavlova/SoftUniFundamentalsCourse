package MidExamPrep;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(sc.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = sc.nextLine();


        while(!command.contains("End")){

            String [] com = command.split(" ");
            int idx = Integer.parseInt(com[1]);
            int pvr = Integer.parseInt(com[2]);

            if(command.contains("Shoot") && isIdxValid(targets, idx)) {
                targets.set(idx, targets.get(idx) - pvr);
                if (targets.get(idx) <= 0){
                    targets.remove(idx);
                }
            }

            if(command.contains("Add")){
                if (isIdxValid(targets, idx)){
                    targets.add(idx, pvr);
                } else {
                    System.out.println("Invalid placement!");
                }
            }

            if(command.contains("Strike")) {
                int startIdx = idx - pvr;
                int endIdx = idx + pvr;
                if (isIdxValid(targets, startIdx) && (isIdxValid(targets, endIdx))){
                    targets.subList(startIdx, endIdx + 1).clear();
                }else {
                    System.out.println("Strike missed!");
                }

            }

            command = sc.nextLine();

        }

        List<String> finalTargets = new ArrayList<>();

        for (int i = 0; i <= targets.size()-1; i++) {
            finalTargets.add(String.valueOf(targets.get(i)));
        }
        System.out.println(String.join("|", finalTargets));
    }
    public static boolean isIdxValid (List<Integer> targets, int idx){
        if (idx >=0 && idx <= targets.size()-1){
            return true;
        }
        return false;
    }
}
