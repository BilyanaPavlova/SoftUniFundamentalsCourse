package ExamPrep_FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2_04_FancyBarcodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            Pattern pattern = Pattern.compile("(@#+)(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)");
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String code = "";

                String prod = matcher.group("product");
                for (int j = 0; j < prod.length(); j++) {
                    if (Character.isDigit(prod.charAt(j))){
                        code += prod.charAt(j);
                        continue;
                    }
                }
                if (!code.equals("")){
                    System.out.printf("Product group: %s\n", code);
                } else {
                    System.out.println("Product group: 00");
                }

            }else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
