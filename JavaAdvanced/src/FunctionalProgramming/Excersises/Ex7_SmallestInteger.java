package FunctionalProgramming.Excersises;

//Write a program that is using a custom function (written by you) to find the smallest integer in a sequence of integers.
// The input could have more than one space. Your task is to collect the integers from the console,
// find the smallest one and print its index (if more than one such elements exist, print the index of the rightmost one).
//input 1 2 3 0 4 5 6


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex7_SmallestInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallest = theList -> {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < theList.size(); i++) {
                int num = theList.get(i);
                if (num <= min) {
                    min = num;
                    idx = i;
                }
            }
            return idx;
        };

        // alternative function
        Function<List<Integer>, Integer> alternativeFindSmallest = li -> {
            //find the min using a stream, instead of forEach method
            int min = li.stream().mapToInt(Integer::intValue).min().getAsInt(); //if a value is present, returns the value,
                                                                                        // otherwise returns NoSuchElementException
            //find the rightmost index
            return li.lastIndexOf(min);
        };

        System.out.println(findSmallest.apply(list));
        System.out.println(alternativeFindSmallest.apply(list));

    }
}