package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2_EncryptingPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            Pattern pattern = Pattern.compile("(.+)>(?<first>\\d{3})\\|(?<second>[a-z]{3})\\|(?<third>[A-Z]{3})\\|(?<fourth>[^<>]{3})<\\1");
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                System.out.print("Password: ");
                String concat = matcher.group("first")
                        + matcher.group("second")
                        + matcher.group("third")
                        + matcher.group("fourth")
                        ;

                System.out.println(concat);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
