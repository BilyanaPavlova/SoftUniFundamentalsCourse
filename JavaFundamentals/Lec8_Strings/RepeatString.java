package Lec8_Strings;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {

        String str = "abc";

        String[] strArr = new String [3];

        for (int i = 0; i < str.length(); i++) {
            strArr[i] = str;
        }

        System.out.println(String.join("", strArr));

    }
}
