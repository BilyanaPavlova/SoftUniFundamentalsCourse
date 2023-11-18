package Lec3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReadArrayFromConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //reading string array
        String [] banned = Arrays.stream(sc.nextLine().split(" "))
                .toArray(String[]::new);

        //reading int array
        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

    }
}
