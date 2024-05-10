package FunctionalProgramming.Excersises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Ex2_KnightsOfHonor {

//    Write a program that reads a collection of names as strings from the console (Peter George Alex Stan)
//    and then appends "Sir" in front of every name and prints it back onto the console. Use a Consumer<T>.

    public static void main(String[] args) {

        Consumer<String> consumer = (s) -> System.out.println("Sir " + s);

        Scanner sc = new Scanner(System.in);

        String [] array = sc.nextLine().split("\\s+");

//        Arrays.stream(array).forEach(consumer);

        for(String s: array){
            consumer.accept(s);
        }

    }
}
