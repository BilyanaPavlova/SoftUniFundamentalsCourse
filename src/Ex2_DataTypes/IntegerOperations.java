package Ex2_DataTypes;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());
        int third = Integer.parseInt(sc.nextLine());
        int fourth = Integer.parseInt(sc.nextLine());

        int sum = first + second;
        double division = sum / third;
        double product = division * fourth;

        System.out.printf("%.0f", product);
    }
}
