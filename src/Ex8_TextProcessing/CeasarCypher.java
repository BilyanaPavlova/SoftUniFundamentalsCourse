package Ex8_TextProcessing;

import java.util.Scanner;

public class CeasarCypher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] inputChars = sc.nextLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char ch :
                inputChars) {
          int ascii = (int)ch;
          int newAscii = ascii + 3;
          ch = (char)newAscii;
          sb.append(ch);
        }

        System.out.println(sb);


    }
}
