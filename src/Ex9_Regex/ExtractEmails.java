package Ex9_Regex;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String email = "(?<username>[A-Za-z0-9]+(?:[-_.]?[a-zA-Z0-9]+)*)@(?<domain>([A-Za-z]+)([-][A-Za-z]+)*)\\.(?<extention>[A-Za-z]+(([-]|\\.)[A-Za-z]+)*)";


        Pattern pattern = Pattern.compile(email);
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            String user = matcher.group("username");
            String dom = matcher.group("domain");
            String ext = matcher.group("extention");
            System.out.println(user +"@" + dom + "." + ext);
        }
    }
}
