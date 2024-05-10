package FunctionalProgramming.Excersises;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

public class Ex3_CustomMinFunction {

//    Write a simple program that reads a set of numbers from the console (1 4 3 2 1 7 13)
//    and finds the smallest of the numbers using a simple Function<Integer[], Integer>.

    public static void main(String[] args) {

        Function<Integer[], Integer> findMin = (numbers) -> {
            int min = Arrays.stream(numbers)
                    .mapToInt(Integer::intValue)
                    .min()
                    .orElse(0);

            return min;
        };

        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split("\\s+");

        Integer[] integerArray = Arrays.stream(strArr)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

       int minimal = findMin.apply(integerArray);
        System.out.println(minimal);
    }
}
