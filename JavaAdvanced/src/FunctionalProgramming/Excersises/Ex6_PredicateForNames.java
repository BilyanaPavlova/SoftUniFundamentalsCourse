package FunctionalProgramming.Excersises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex6_PredicateForNames {

//    Write a predicate. Its goal is to check a name for its length and to return true if the length of the name is less or equal
//    to the passed integer. You will be given an integer that represents the length you have to use.
//    On the second line, you will be given a string array with some names. Print the names, passing the condition in the predicate.

//   input
//    4
//Sara Sam George Mark John

//    output
//Sara
//Sam
//Mark
//John

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] array = (sc.nextLine().split("\\s+"));

        Predicate<String> predicate = str -> str.length() <= n;

//        for(String str: array){
//            if(predicate.tests(str)){
//                System.out.println(str);
//            }
//        }

        //second way with stream

        Arrays.stream(array).filter(predicate).forEach(System.out::println);


    }
}
