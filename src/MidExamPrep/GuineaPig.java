package MidExamPrep;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double food = Double.parseDouble(sc.nextLine()) * 1000;
        double hay = Double.parseDouble(sc.nextLine()) * 1000;
        double cover = Double.parseDouble(sc.nextLine()) * 1000;
        double pigWeight = Double.parseDouble(sc.nextLine()) * 1000;
        int days = 30;
        int currentDay = 1;
        boolean isShortage = false;

        while (currentDay <= 30){



            food -= 300;
            days --;

            if (currentDay % 2 == 0){
                hay -= food * 0.05;
            }

            if (currentDay % 3 == 0){
                cover -= pigWeight / 3;
            }
            if(food <=0 || hay <= 0 || cover <= 0){
                isShortage = true;
                break;
            }

            currentDay++;

        }

        if (isShortage) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf(	"Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    food /1000, hay / 1000, cover / 1000);
        }
    }
}
