package FunctionalProgramming.Lec;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Lec2_SumNumbers_Functional {

//    Write a program that reads one line of Integers separated by ", ".
//    Print the count of the numbers and their sum.
//Use a Function<String, Integer>.

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();


        // IntStream - последователност от int, int, int
        // Stream<Integer> - последователност от  Integer, Integer
        // stream.sum - второто няма

//        IntStream - връща се с mapToInt(Integer::parseInt);
//        Stream<Integer> - връща се с .map(Integer::parseInt);

        //създаваме две функции, на които подаваме стрийма о който връщат w string брой и сума
        Function<IntStream, String> count = stream -> "Count " + stream.count();
        Function<IntStream, String> sum = stream -> "Sum " + stream.sum();

        // превръщаме стринга в интстрийм от интс
        IntStream intStream = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt);// option+command+V - показва ми какво връща

        System.out.println(count.apply(intStream));

        // прави втори поток, защото count е затворил първия
        IntStream intStream1 = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt);

        System.out.println(sum.apply(intStream1));

    }
}
