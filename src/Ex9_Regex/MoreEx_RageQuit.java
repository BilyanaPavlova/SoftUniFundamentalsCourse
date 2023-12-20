package Ex9_Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreEx_RageQuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        Pattern pattern = Pattern.compile("((?<group>[^\\d]{1,20})(?<nums>[0-9]{1,2}))");
        Matcher matcher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();
        StringBuilder counter = new StringBuilder();

        while(matcher.find()){
            String match = matcher.group("group");
            String num = matcher.group("nums");

            for (int i = 0; i < Integer.parseInt(num); i++) {
                sb.append(match.toUpperCase());
            }

            for (char ch :
                    match.toCharArray()) {
                if (Character.isLetter(ch)){
                    ch = Character.toUpperCase(ch);
                }

                if (!counter.toString().contains(String.valueOf(ch))){
                    counter.append(ch);
                }
            }

        }
        System.out.printf("Unique symbols used: %d\n", counter.length());
        System.out.println(sb);
    }

}


