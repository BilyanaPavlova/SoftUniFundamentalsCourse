package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] targets = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String command = sc.nextLine();
        int count = 0;
        while (!command.equals("End")){

            int idx = Integer.parseInt(command);

            if(isIdxValid(targets, idx)){
                int value = 0;
                for (int i = 0; i <= targets.length-1; i++) {
                    if(i == idx){
                        value = targets[i];
                        targets[i] = -1;
                        count++;
                        break;
                    }
                }

                for (int i = 0; i <= targets.length - 1; i++) {
                    if(targets[i] != -1){
                        if (targets[i] > value){
                            targets[i] -= value;
                        } else {
                            targets[i] += value;
                        }
                    }
                }
            }

            command = sc.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        System.out.println(Arrays.toString(targets)
                .replaceAll("[\\]\\[\\,]", ""));


    }

    public static boolean isIdxValid(int[]targets, int idx){
        if (idx >= 0 && idx <= targets.length - 1 && targets[idx] != -1 ){
            return true;
        }
        return false;
    }
}
