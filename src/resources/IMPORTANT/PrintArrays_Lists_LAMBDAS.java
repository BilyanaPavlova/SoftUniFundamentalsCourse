package resources.IMPORTANT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintArrays_Lists_LAMBDAS {
    public static void main(String[] args) {

        // print with a lambda expression

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // Print elements using forEach() and lambda expression
        System.out.println("List Elements:");
        list.forEach(element -> System.out.println(element));


        // print with an array

        System.out.println("List Elements:");
        for (String element : list) {
            System.out.println(element);

        }


//изчисляване на средното от лист с инт, който е стойност на мап
//double averageRating = plantsRating.get(plantName).stream().mapToDouble(a -> a).average().orElse(0.0);

// what is (а->а) LAMBDA EXPRESSIONS
//The expression (a -> a) is a lambda expression in Java. It represents a simple lambda function, also known as an anonymous function or lambda, which takes a parameter a and returns the same value a.
// The syntax (a -> a) is equivalent to a function that takes an argument a and returns a.
//
//In Java, lambda expressions provide a concise way to express instances of functional interfaces (interfaces with a single abstract method).
// They are often used to define inline implementations of interfaces without the need for a separate anonymous class.
//
//Here's an example of how you might use (a -> a) in a context like a stream operation:

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using a lambda expression to double each number in the list
        List<Integer> doubledNumbers = numbers.stream()
                .map(a -> a * 2)
                .collect(Collectors.toList());

        System.out.println(doubledNumbers);  // Output: [2, 4, 6, 8, 10]
    }
}