package Lec_HTML;

import java.util.Scanner;

public class CenterPoint_SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1 = Double.parseDouble(sc.nextLine());
        double y1 = Double.parseDouble(sc.nextLine());
        double x2 = Double.parseDouble(sc.nextLine());
        double y2 = Double.parseDouble(sc.nextLine());

        printClosestToCenter(x1, y1, x2, y2);



    }

    private static double calculateDistanceFromCenter(double x, double y){
        double distance = Math.sqrt(Math.pow(Math.abs(x),2) + Math.pow(Math.abs(y),2));
        return distance;
    }

    public static void printClosestToCenter(double x1, double y1, double x2, double y2){
        double distance1 = calculateDistanceFromCenter(x1,y1);
        double distance2 = calculateDistanceFromCenter(x2,y2);

        if (distance1 <= distance2){
            System.out.printf("(%.0f, %.0f)", x1, y1);
        } else {
            System.out.printf("(%.0f, %.0f)", x2, y2);
        }
    }
}
