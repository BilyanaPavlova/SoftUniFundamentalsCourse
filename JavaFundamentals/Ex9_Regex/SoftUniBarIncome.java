package Ex9_Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        double totalIncome = 0.0;

        while(true){
            if(input.equals("end of shift")){
                System.out.printf("Total income: %.2f", totalIncome);
                return;
            }

            Pattern pattern = Pattern.compile("%(?<customerGroup>[A-Z][a-z]+)%" +
                    "(?:[^|.%$]+)*" +
                    "<(?<productGroup>[A-Z][a-z]+)>" +
                    "(?:[^|.%$]+)*" +
                    "\\|(?<countGroup>\\d+)\\|" +
                    "(?:[^|.%$0-9]+)*" +
                    "(?<priceGroup>\\d+\\.?(\\d+)*)\\$");

            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){

                String customer = matcher.group("customerGroup");
                String product = matcher.group("productGroup");
                int count = Integer.parseInt(matcher.group("countGroup"));
                double price = Double.parseDouble(matcher.group("priceGroup"));

                double totalPrice = count * price;
                totalIncome += totalPrice;

                System.out.printf("%s: %s - %.2f\n", customer, product, totalPrice);
            }

            input = sc.nextLine();
        }

    }
}
