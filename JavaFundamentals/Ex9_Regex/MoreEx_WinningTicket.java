package Ex9_Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreEx_WinningTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(",\\s");

        for (String el:
             arr) {
//            Pattern pattern = Pattern.compile("[\\w\\:\\(\\)\\*\\-\\=\\+\\%\\|\\&\\!\\@\\#\\^\\$]{20}");
            Pattern pattern = Pattern.compile("([^,\\s]{20})");
            Matcher matcher = pattern.matcher(el);
            if(matcher.find()){
               String ticket = matcher.group();
               String left = ticket.substring(0, 10);
               String right = ticket.substring(10);

//                System.out.println(left);
//                System.out.println(right);

                Pattern pattern1 = Pattern.compile("([@#$^]{6,})");
                Matcher matcherLeft = pattern1.matcher(left);
                Matcher matcherRight = pattern1.matcher(right);

                String matchLeft = "";
                String matchRight = "";

                if(matcherLeft.find() && matcherRight.find()) {
                    matchLeft = matcherLeft.group();
                    matchRight = matcherRight.group();
//                    System.out.println(matchLeft);
//                    System.out.println(matchRight);

                    if (matchLeft.length() < 10 && matchLeft.equals(matchRight)) {
                        System.out.println("ticket \"" + ticket + "\" - " + matchLeft.length() + matchLeft.charAt(0));
                    } else {
                        System.out.println("ticket \"" + ticket + "\" - " + matchLeft.length() + matchLeft.charAt(0) + " Jackpot!");

                    }
                } else {
                    System.out.println("ticket \"" + ticket + "\" - no match" );

                }

            }else {
                System.out.println("invalid ticket");
            }

        }
    }
}
