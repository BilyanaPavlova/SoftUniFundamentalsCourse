package Ex8_TextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] chArr = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chArr.length-1; i++) {
            if(chArr[i] != chArr[i+1]){
                sb.append(chArr[i]);

            }
        }
        sb.append(chArr[chArr.length-1]);
        System.out.println(sb);
    }
}
