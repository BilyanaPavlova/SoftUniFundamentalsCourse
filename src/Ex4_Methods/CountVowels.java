package Ex4_Methods;

import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().toLowerCase();

        printCountVowels(text);


    }

    public static void printCountVowels(String text){
        int count = 0;
        for (char letter: text.toCharArray()) {
            if (letter == 'a' ||
            letter =='e' ||
            letter =='u'||
            letter =='o' ||
            letter =='i' ){
                count++;
            }

        }
        System.out.println(count);
    }
}
