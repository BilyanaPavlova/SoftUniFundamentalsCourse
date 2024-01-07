package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task5_BiggestElement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isBigger = true;
        for (int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if (numbers[i] <= numbers[j]){
                    isBigger = false;
                    }
            }
            if(isBigger){
                System.out.print(numbers[i] + " ");
            }
            isBigger = true;
        }



    }
}
