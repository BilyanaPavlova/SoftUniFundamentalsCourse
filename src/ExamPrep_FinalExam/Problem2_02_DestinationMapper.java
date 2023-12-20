package ExamPrep_FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2_02_DestinationMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Pattern pattern = Pattern.compile("(=[A-Z][A-Za-z]{2,}=)|(\\/[A-Z][A-Za-z]{2,}\\/)");
        Matcher matcher = pattern.matcher(input);


        List<String> destinations = new ArrayList<>();
        int sum = 0;
        while(matcher.find()){
            String destination = matcher.group();
            String dest = destination.substring(1, destination.length()-1);
            sum += dest.length();
            destinations.add(dest);
        }

        String joined = String.join(", ", destinations);
        System.out.println("Destinations: " + joined);
        System.out.printf("Travel Points: %d", sum);
    }


}
