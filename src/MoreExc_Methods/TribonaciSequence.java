package MoreExc_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class TribonaciSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        System.out.println(Arrays.toString(printTrbonaciSeqence(num))
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }

    public static int[] printTrbonaciSeqence(int num) {

//        1 1 2 4 7
        int [] tribonaciArr = new int[num];
        for (int i = 0; i < num; i++) {
            if (i == 0){
                tribonaciArr[i] = i + 1;
            }
            if(i == 1){
                tribonaciArr[i]= i;
            }
            if (i == 2){
                tribonaciArr[i] = i;
            }
            if (i >= 3){
                for (int j = 3; j < num; j++) {
                    tribonaciArr[j] = tribonaciArr[j - 1] + tribonaciArr[j - 2] + tribonaciArr[j-3];
                }
                break;

            }
        }
        return tribonaciArr;
    }
}
