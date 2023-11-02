package Lec6_ClassesObjects;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(result);
    }
}
