package FunctionalProgramming.Excersises;

//Write a custom comparator that sorts all even numbers before all odd ones in ascending order.
// Pass it to an Arrays.sort() function and print the result.
//input 1 2 3 4 5 6
//output 2 4 6 1 3 5

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ex8_CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> reorder = arr -> {
            int[] even = Arrays.stream(arr)
                    .filter(e -> e % 2 == 0)
                    .sorted()
                    .toArray();
            int[] odd = Arrays.stream(arr)
                    .filter(e -> e % 2 != 0)
                    .sorted()
                    .toArray();
            int [] evenOdd = new int[even.length + odd.length];

            System.arraycopy(even, 0, evenOdd, 0, even.length);

            // Copy elements of array2 into combinedArray starting from the end of array1
            System.arraycopy(odd, 0, evenOdd, even.length, odd.length);

            return evenOdd;
        };

        int[] newArr = reorder.apply(nums);

        Consumer <int[]> printer = arr -> {
            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        };


        printer.accept(newArr);

        System.out.println("------------------------------ second way Comparator-------------------");

        // Use the Comparator Functional interface, which is commonly used with sorting methods of collections and arrays

        // Custom comparator to sort even numbers before odd numbers in ascending order
        Comparator<Integer> evenBeforeOddComparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) { // num1 is even and num2 is odd
                return -1; // Places num1 before num2
            } else if (num1 % 2 != 0 && num2 % 2 == 0) { // num1 is odd and num2 is even
                return 1; // Places num2 before num1
            } else { // Both even or both odd, compare them normally
                return num1.compareTo(num2);
            }
        };

        //turn the int[] to Integer[]

        Integer[] array = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);//toArray(Integer[]::new) method to collect the Integer objects into an array of Integer.

        // Sort the array using the custom comparator
        Arrays.sort(array, evenBeforeOddComparator);

        printer.accept(Arrays.stream(array).mapToInt(Integer::intValue).toArray()); // convert Integer[] to int[] and print

    }
}
