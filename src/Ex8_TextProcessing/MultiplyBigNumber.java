package Ex8_TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bigNumber = sc.nextLine();
        byte smallNumber = sc.nextByte();

        StringBuilder sb = new StringBuilder();

        char[] chArr = bigNumber.toCharArray();


        int keptInMind = 0;
        for (int i = chArr.length - 1; i >= 0; i--) {
            int numericValue = Character.getNumericValue(chArr[i]);
            int product = smallNumber * numericValue;

            if(product + keptInMind < 10){
                sb.insert(0, String.valueOf(product + keptInMind));
                keptInMind = 0;
            } else {
                sb.insert(0, (char) ((product + keptInMind) % 10 + '0'));
                keptInMind = (product + keptInMind) / 10;
            }
        }
        if(keptInMind != 0){
            sb.insert(0, keptInMind);
        }
        System.out.println(sb);
    }
}
