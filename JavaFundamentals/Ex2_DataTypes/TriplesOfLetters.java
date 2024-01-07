package Ex2_DataTypes;

import java.util.Scanner;

public class TriplesOfLetters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

//        a b c


        for (int i = 'a'; i < 'a' + n; i++) {

            for (int j = 'a'; j < 'a' + n; j++) {

                for (int k = 'a'; k < 'a' + n ; k++) {

                    String text = String.format("%c%c%c",i, j, k);
                    System.out.println(text);

                }


            }
            
        }
    }
}
