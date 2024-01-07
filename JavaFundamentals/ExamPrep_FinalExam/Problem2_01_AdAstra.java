package ExamPrep_FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2_01_AdAstra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Pattern pattern = Pattern.compile("(\\||#)(?<name>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();

        int totalCalories = 0;
        while(matcher.find()){
            String food = matcher.group("name");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            totalCalories += calories;
            sb.append("Item: " + food + ", ");
            sb.append("Best before: " + date +", ");
            sb.append("Nutrition: " + calories + "\n");
        }

        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!\n", days);

//        "Item: {item name}, Best before: {expiration date}, Nutrition: {calories}"

        System.out.println(sb);

    }

}
