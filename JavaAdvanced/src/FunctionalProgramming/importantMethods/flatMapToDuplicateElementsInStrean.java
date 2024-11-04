package FunctionalProgramming.importantMethods;

import java.util.Arrays;
import java.util.stream.IntStream;

public class flatMapToDuplicateElementsInStrean {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // Use flatMap to duplicate each element
        IntStream duplicatedStream = Arrays.stream(array)
                .flatMap(element -> IntStream.of(element, element));

        // Print the resulting stream
        duplicatedStream.forEach(System.out::println);
    }
}
