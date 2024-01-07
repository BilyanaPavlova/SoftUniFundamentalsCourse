package Lec8_Strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReplaceWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] banned = Arrays.stream(sc.nextLine().split(" "))
                        .toArray(String[]::new);

        String text = sc.nextLine();

        for (int i = 0; i < banned.length; i++) {

//            no need of a loop, because replace(matched, replacement) replaces all occurences

                String replacement = repeatWordForNumberOfCount("*", banned[i].length());
                text = text.replace(banned[i], replacement);

// with a loop
//            while(text.contains(banned[i])){
//                String replacement = repeatWordForNumberOfCount("*", banned[i].length());
//                text = text.replaceFirst(banned[i], replacement);
//            }

        }
        System.out.println(text);

    }

    public static String repeatWordForNumberOfCount(String str, int count){
        String[]strings = new String[count];
//        for (int i = 0; i < count; i++) {
//            strings[i] = str;
//        }

        Arrays.fill(strings, str); // avoid the loop, use a method
        return String.join("", strings);
    }
}
