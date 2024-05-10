package FunctionalProgramming.Lec;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Lec3_Predicate_Queue {

    //    Write a program that reads one line of text from the console. Print the count of words
    //    that start with an Uppercase letter,
//    after that print all these words in the same order as you found them in the text.
//Use a Predicate<String> like an if-condition.

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");

        //define a Predicate function interface to return words with upper case
        Predicate<String> isStartingWithUpperCase = w -> Character.isUpperCase(w.charAt(0));

        // define a que to store the words
        ArrayDeque<String> queueOfWOrds = new ArrayDeque<>();

        // use stream API and pass a function to the filter function and then to put each filtered word in the queue
        Arrays.stream(words)
                .filter(isStartingWithUpperCase)
                .forEach(queueOfWOrds::offer);

        //print the number
        System.out.println(queueOfWOrds.size());

        //print the words
        while(!queueOfWOrds.isEmpty()){
            System.out.println(queueOfWOrds.poll());
        }
    }
}
