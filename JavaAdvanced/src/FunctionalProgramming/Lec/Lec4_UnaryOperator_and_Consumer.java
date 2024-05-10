package FunctionalProgramming.Lec;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Lec4_UnaryOperator_and_Consumer {


    // Write a program that reads one line of Double prices separated by ", ".
    // Print the prices with added VATs for all of them.
    // Format them to the 2nd digit after the decimal point.
    // The order of the prices must remain the same.
    //
    //Use an UnaryOperator<Double>.

//    In Java, UnaryOperator is a functional interface that represents an operation on a single operand
//    that produces a result of the same type as its operand.
//    It's a specialization of the more general Function interface, where the input and output types are the same.
//
//The UnaryOperator interface is defined as follows:


//@FunctionalInterface
//public interface UnaryOperator<T> extends Function<T, T> {
//    // No additional abstract methods
//}
//As you can see, UnaryOperator extends the Function<T, T> interface,
// which means it inherits the apply method from Function.
// The apply method takes a single argument of type T and returns a result of the same type T.
//
//Here's an example of using UnaryOperator to define a simple unary operation:
//

//        // Define a UnaryOperator to double a number
//        UnaryOperator<Integer> doubleNumber = x -> x * 2;
//
//        // Apply the operation to a number
//        int result = doubleNumber.apply(5);
//        System.out.println("Result: " + result); // Output: 10


//In this example:
//
//We define a UnaryOperator named doubleNumber, which takes an integer as input
// and returns the result of doubling that integer.
//We then apply the doubleNumber operation to the number 5, resulting in 10.

//UnaryOperator is commonly used in functional programming scenarios
// where a transformation or operation needs to be applied to a single input value
// to produce a result of the same type. It's particularly useful in combination with Java's Stream API,
// where it can be used for mapping operations.

//    =======================
//    Consumer<T>
//    In Java, Consumer is a functional interface that represents an operation
//    that accepts a single input argument and returns no result.
//    It's often used when you need to consume or process an input without returning any output.
//
//The Consumer interface is defined as follows:
//
//@FunctionalInterface
//public interface Consumer<T> {
//    void accept(T t);
//
//    // Other default and static methods may be present in the interface
//}

//As you can see, Consumer has a single abstract method named accept,
// which takes an argument of type T and returns void.
// This method is where the operation to be performed on the input is defined.
//
//Here's an example of using Consumer to print the elements of a list:
//

//        // Create a list of integers
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//        // Define a Consumer to print each element of the list
//        Consumer<Integer> printNumber = num -> System.out.println(num);
//
//        // Iterate over the list and apply the Consumer to each element
//        numbers.forEach(printNumber);

//In this example:
//
//We define a Consumer named printNumber, which accepts an integer and prints it to the console.
//We use the forEach method on the list of integers to apply the printNumber Consumer to each element of the list.
//Consumer is commonly used in functional programming scenarios where you need to perform an action or operation on each element of a collection, without needing to return any result. It's often used in conjunction with higher-order functions like forEach, map, filter, and flatMap in Java's Stream API.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] prices = Arrays.stream(sc.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator applyVAT = x -> x += x * 0.2;

        Consumer<double[]> printPrice = p -> {
            System.out.println("Prices with VAT:");
            System.out.println(Arrays.stream(p)
                    .map(applyVAT)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));

        };

        printPrice.accept(prices);


    }

}
