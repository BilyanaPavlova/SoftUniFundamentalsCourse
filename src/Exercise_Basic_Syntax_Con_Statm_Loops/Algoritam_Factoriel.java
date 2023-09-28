package Exercise_Basic_Syntax_Con_Statm_Loops;

import java.util.Scanner;

public class Algoritam_Factoriel {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int number = Integer.parseInt(sc.nextLine());

        int factoriel = 1;
        for (int i = 1; i <= number; i++){
            factoriel *= i;
        }

        System.out.println(factoriel);
    }
}
