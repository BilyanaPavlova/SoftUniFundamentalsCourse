package FunctionalProgramming.Excersises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex5_ReverseExcludeCollection {

//    Write a program that reverses a collection and removes elements that are divisible by a given integer n.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> coll = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()); // toList() - collects to immutable list!!!!
                                                // collect(Collections.toList()) - collects to mutable list!!!!

        int n = Integer.parseInt(sc.nextLine());

        // coll is mutable and is mutated by the next operations

        Collections.reverse(coll);

//        coll.removeIf(num -> num % n == 0);

        //or
        Predicate<Integer> predicate = num -> num % n == 0;
        coll.removeIf(predicate);

        coll.forEach(num -> System.out.print(num + " "));



    }
}

