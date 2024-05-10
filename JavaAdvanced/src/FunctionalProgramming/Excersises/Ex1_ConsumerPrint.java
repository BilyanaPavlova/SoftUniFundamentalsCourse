package FunctionalProgramming.Excersises;

// Write a program that reads a collection of strings, separated by one or more whitespaces,
// from the console and then prints them onto the console. Each string should be printed on a new line. Use a Consumer<T>.


import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Ex1_ConsumerPrint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a Consumer to print each string on a new line
        // Consumer<String> consumer = (String a) -> System.out.println(a);
        Consumer<String> consumer = System.out::println;

        //split the line into strings in an array
        String [] array = sc.nextLine().split("\\s+");

        // Create a stream from the array of strings and apply the Consumer to each element
        Arrays.stream(array).forEach(consumer);


    }

}
