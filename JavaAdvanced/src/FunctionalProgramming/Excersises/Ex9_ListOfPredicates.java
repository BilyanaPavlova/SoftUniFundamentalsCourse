package FunctionalProgramming.Excersises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex9_ListOfPredicates {

//    Find all numbers in the range 1..N that is divisible by the numbers of a given sequence. Use predicates.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List <Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        List<Integer> divisors = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiPredicate<Integer, List<Integer>> predicate = (number, diviisors)-> {

            for (int divisor : diviisors) {
                if (number % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        List<Integer> result = numbers.stream().filter(m -> predicate.test(m, divisors)).toList();

        result.forEach(num -> System.out.print(num + " "));

    }
}
