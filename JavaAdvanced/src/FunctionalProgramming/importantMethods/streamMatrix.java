package FunctionalProgramming.importantMethods;

import java.util.Arrays;

public class streamMatrix {
//    can I use a stream and a lambda to foreach a matrix elements

    /*Yes, you can use streams and lambda expressions to iterate over the elements of a matrix in Java. To do this, you will need to convert the 2D array (matrix) into a stream. Here's how you can achieve this:

1.Convert the 2D array into a stream of arrays.
2.Use flatMap to flatten the stream of arrays into a stream of elements.
3.Use forEach to iterate over the elements with a lambda expression.
*/

    public static void main(String[] args) {
        // Define a sample 2D array (matrix) of integers
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Use streams to iterate over the matrix elements
        Arrays.stream(matrix)        // Stream<int[]>: Stream of rows (int[] arrays)
                .flatMapToInt(Arrays::stream) // IntStream: Flatten each row into the stream of integers
                .forEach(element -> System.out.println(element)); // Print each element
    }
}
