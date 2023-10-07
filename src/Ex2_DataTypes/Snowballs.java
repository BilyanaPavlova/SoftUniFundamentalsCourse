package Ex2_DataTypes;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfSnowBalls = Integer.parseInt(sc.nextLine());
        int snowballSnow = 0;
        int snowballTime = 0;
        int snowballQuality = 0;
        double biggestSnowBallValue = 0;
        int biggestSnowBallSnow = 0;
        int biggestSnowBallTime = 0;
        int biggestSnowBallQuality = 0;
        double snowballValue = 0;

        for (int i = 0; i < numberOfSnowBalls; i++) {

            snowballSnow = Integer.parseInt(sc.nextLine());
            snowballTime = Integer.parseInt(sc.nextLine());
            snowballQuality = Integer.parseInt(sc.nextLine());

//            (snowballSnow / snowballTime) ^ snowballQuality

            snowballValue =  Math.pow((snowballSnow / snowballTime), snowballQuality) ;
            if (snowballValue > biggestSnowBallValue){
                biggestSnowBallValue = snowballValue;
                biggestSnowBallSnow = snowballSnow;
                biggestSnowBallTime = snowballTime;
                biggestSnowBallQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)",
                biggestSnowBallSnow, biggestSnowBallTime, biggestSnowBallValue, biggestSnowBallQuality);


    }
}
