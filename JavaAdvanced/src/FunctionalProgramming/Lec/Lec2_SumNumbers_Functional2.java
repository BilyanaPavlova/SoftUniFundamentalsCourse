package FunctionalProgramming.Lec;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class Lec2_SumNumbers_Functional2 {

    //    Write a program that reads one line of Integers separated by ", ".
//    Print the count of the numbers and their sum.
//Use a Function<String, Integer>.

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // define the functions
        Function<int[], String> count = arr -> "Count = " + Arrays.stream(arr).count();
        Function<int[], String> sum = arr -> "Sum = " + Arrays.stream(arr).sum();

        //turn String s into array of int - use mapToInt for int, map for Integer
        int[] arr = Arrays.stream(s.split(", "))
                .mapToInt(Integer::parseInt) // create a stream of int
                .toArray();// collect in an Array

        // with apply method apply the arr as a parameter to each function
        String applyCount = count.apply(arr);
        String applySum = sum.apply(arr);

        //print
        System.out.println(applyCount);
        System.out.println(applySum);

    }
}
