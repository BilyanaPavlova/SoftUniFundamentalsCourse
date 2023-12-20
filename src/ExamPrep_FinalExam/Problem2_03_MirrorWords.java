package ExamPrep_FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2_03_MirrorWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        List<String> validWords = new ArrayList<>();

        String input = sc.nextLine();

        Pattern pattern = Pattern.compile("(@|#)[A-Za-z]{3,}\\1\\1[A-Za-z]{3,}\\1");
        Matcher matcher = pattern.matcher(input);


        int count = 0;
        while(matcher.find()){
            String pair = matcher.group();
            count++;

            char symbol = pair.charAt(0);

            StringBuilder sb = new StringBuilder(pair);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);

            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == symbol){
                    sb.replace(i,i+1,"|");
                }
            }

            String[] words = sb.toString().split("\\|\\|");

            if (words[0].contentEquals((new StringBuilder(words[1]).reverse()))) {
                validWords.add(words[0] + " <=> " + words[1]);
            }
        }


        if(count == 0){
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!\n",count);
        }

        if (!validWords.isEmpty()){
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", validWords));
        } else {
            System.out.println("No mirror words!");
        }

    }
}
