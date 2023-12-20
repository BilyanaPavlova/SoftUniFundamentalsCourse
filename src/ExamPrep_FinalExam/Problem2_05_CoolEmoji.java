package ExamPrep_FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2_05_CoolEmoji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);

        List<String> coolEmojis = new ArrayList<>();

        int treshHold = 1;
        while(matcher.find()){
            int d = Integer.parseInt(matcher.group());
            treshHold *= d;
        }

        int ascii = 0;
        pattern = Pattern.compile("(:{2}|\\*{2})[A-Z][a-z]{2,}\\1");
        matcher = pattern.matcher(input);
        int count = 0;
        while(matcher.find()){
            String emoji = matcher.group();
            count++;
            String word = emoji.substring(2, emoji.length()-2);


            for (int i = 0; i < word.length(); i++) {
                ascii += word.charAt(i);
            }
            if (ascii > treshHold){
                coolEmojis.add(emoji);
            }
            ascii = 0;

        }

        System.out.printf("Cool threshold: %d\n", treshHold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", count);
        coolEmojis.forEach(el -> System.out.println(el));
    }


}
