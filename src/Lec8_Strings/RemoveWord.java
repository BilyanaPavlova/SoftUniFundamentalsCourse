package Lec8_Strings;

import java.util.Scanner;

public class RemoveWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // first way:
//        String removeWord = sc.nextLine();
//        String text = sc.nextLine();

//        while(text.contains(removeWord)){
//            int idx = text.indexOf(removeWord);
//            text = text.substring(0,idx).concat(text.substring(idx + removeWord.length()));
//        }
//
//        System.out.println(text);

        // second way with replace:
        // searching that cannot find sth return always -1

        String key = sc.nextLine();
        String text = sc.nextLine();
        int index = text.indexOf(key);
        while (index != -1) {
            text = text.replace(key,
                    "");
            index = text.indexOf(key);
        }
        System.out.println(text);
    }
}