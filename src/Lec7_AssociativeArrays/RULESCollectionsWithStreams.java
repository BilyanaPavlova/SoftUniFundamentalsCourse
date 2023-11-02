package Lec7_AssociativeArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RULESCollectionsWithStreams {
    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();

                nums.add(15);
                nums.add(25);
                nums.add(35);

                int max = nums.stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .getAsInt();

        System.out.println(max);

        int min = nums.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();

        System.out.println(min);

        int min1 = nums.stream()
                .min(Integer::compareTo).get();

        System.out.println(min1);

        int max1 = nums.stream().mapToInt(Integer::intValue)
                .max().getAsInt();

        int max2 = nums.stream()
                .max(Integer::compareTo).get();

        int sum = nums.stream()
                .mapToInt(Integer::intValue).sum();

//        -----

//        (Integer::intValue) is a method reference in Java.
//        It is a shorthand notation of a lambda expression
//        and represents a reference to the intValue() method of the Integer class.
//        In the context of the mapToInt operation on a Java Stream,
//        it is used to transform each element of the stream into its primitive int representation.
//
//          Integer is a wrapper class for the int primitive type in Java.
//          :: is the method reference operator in Java.
//          intValue() is a method of the Integer class that converts an Integer object to an int primitive value.
//          When you use (Integer::intValue) as a method reference within the mapToInt operation,
//          it's equivalent to writing a lambda expression explicitly.
//          For example, the method reference (Integer::intValue) is equivalent
//          to the lambda expression (x) -> x.intValue(),
//          where x represents an element of the stream of Integer objects.

//        for :: ask chatGPT what is method reference - detailed explanation  there

        double avg = nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

//      -----
//        map() - manipulates elements in a collection:
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)) //inline function(only needed for this) i.e. lambda expression
                .toArray();

        int[] numbers1 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt) //method reference - the shorthand for lambda expression, when the lambda simply calls a method
                .toArray();
//        ---

//        read for method reference types in ChatGPT !!!:

//        CONVERTING !!!
        String[] words = {"abc", "def", "geh", "yyy"};
        words = Arrays.stream(words)
                .map(w -> w + "yyy")
                .toArray(String[]::new);  // method reference of type constructor. The method reference String[]::new is used to create a new array of strings to hold the elements from the stream.
//abcyyy, defyyy, gehyyy, yyyyyy
//        this is useful when the stream and the array are of elements of the same type

//        CONVERTING !!!! Using toArray(), toList() to convert collections:

        int[] nums3 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        List<Integer> nums4 = Arrays.stream(sc.nextLine()
                        .split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

//        using intermediate operations on a stream (does sth with the stream and not terminating as .toArray, which terminates and collects to array)
        int[] nums5 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .filter(n -> n > 0)
                .toArray();
    }
        }
