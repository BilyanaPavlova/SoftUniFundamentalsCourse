package Lec8_Strings;

import java.util.Scanner;

public class BannedWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] banned = sc.nextLine().split(", ");
        String text = sc.nextLine();

        for (int i = 0; i < banned.length; i++) {
            String replacement = replaceWord(banned[i], "*");
            text = text.replace(banned[i], replacement);
        }

        System.out.println(text);
    }

    public static String replaceWord (String word, String replacement){
        String [] arr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = replacement;
        }
        return String.join("", arr);
    }
}
