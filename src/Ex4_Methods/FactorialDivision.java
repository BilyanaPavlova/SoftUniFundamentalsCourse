package Ex4_Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());

        long factA = calcultaeFactorial(a);
        long factB = calcultaeFactorial(b);
        printDivision(factA, factB);


    }

    // факториелът може да бъде много голямо число => да се съхранява в long
    public static long calcultaeFactorial(int a) {
        long factoriel = 1;
        for (long i = 1; i < a; i++) {
            factoriel *=  (i + 1);
        }
        return factoriel;
    }

    public static void printDivision (long a, long b){
        // делим лонг на лонг = лонг. За да имаме реално деление,
        // трябва да умножим по 1.0 , за да стане дробно
        double c = a * 1.0/b;
        System.out.printf("%.2f", c);
    }

}