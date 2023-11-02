package Lec6_ClassesObjects;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        BigInteger num1 = new BigInteger(sc.nextLine());
//        BigIntegerteger num2 = new BigInteger(sc.nextLine());
        BigInteger num1 = new BigInteger(String.valueOf(sc.nextInt()));
        BigInteger num2 = new BigInteger(String.valueOf(sc.nextInt()));



        BigInteger sum = num1.add(num2);
        System.out.println(sum);

    }
}
