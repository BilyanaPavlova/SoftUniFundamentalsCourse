package Lec3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RULES_ReadArrayFromConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //reading string array -
        String [] banned = Arrays.stream(sc.nextLine().split(" ")) //чете стринг и го сплитва като му пуска стриим
                .toArray(String[]::new); // и после го събира в арей чрез шорткът на ламбда експрешън

        //reading int array
        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

    }
}
