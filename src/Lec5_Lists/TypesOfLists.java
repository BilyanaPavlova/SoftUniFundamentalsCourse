package Lec5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypesOfLists {

    public static void main(String[] args) {

        // 1. fixed-sized list -> it implements the List interface, but add and remove cannot be applied.
        // it's dimensions are fixed , because it is backed by an array
        // used when we do not want to change dimensions, but we want to have more flexibility to access the elemenets
        // used when we have methods or APIs that expect a list as an argument
        // use less memory than fixed-sized lists
        System.out.println("------------ Fixed-Sized List ------------");

        String[] arr = {"apple", "pear", "quince"};

        List<String> fixedSizeList = Arrays.asList(arr);

//        fixedSizeList.add("lemon"); // -> exception
//        fixedSizeList.clear();
        //use lambda to print
        fixedSizeList.forEach(el -> System.out.print(el + " "));

        System.out.println("\n------------ Dynamic List ------------");

        /*2. Dynamic lists - possible to add and remove. They do not have a fixed-size dimension
        * Use the functionalities of the List interface
        * use more memory than fixed-sized lists
        * you can pass to their constructor a fixed-size list and turn it to dynamic list in order to have more functionalities */

        List<String> dynamicSizeList = new ArrayList<>(fixedSizeList);
        dynamicSizeList.add("lemon");
        dynamicSizeList.forEach(el -> System.out.print(el + " "));
        dynamicSizeList.clear();
        dynamicSizeList.forEach(el -> System.out.print(el + " ")); // prints nothing

        /*
        In Java, the List interface and its implementations,
        such as ArrayList and LinkedList, store objects rather than primitive data types.
        They work with objects, so you can store instances of classes
        or wrappers for primitive types (Integer, Double, Boolean, etc.) in a List.

        For example, if you want to store integers in a List, you can use the Integer wrapper class:
        */
        // Create a List of Integer objects:
        List<Integer> integerList = new ArrayList<>();

        // Adding integers to the list (using Integer objects)
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        // Accessing elements from the list
        int firstElement = integerList.get(0);
        System.out.println("First Element: " + firstElement);
        /*
        In this example, the List is declared to store Integer objects.
        This allows you to work with primitive integers indirectly through their corresponding wrapper objects.

        If you want to work with primitive data types directly, without using wrapper classes,
        you can use specialized collections like TIntArrayList from the Trove library or similar libraries
        designed for primitive collections.
        These libraries are more memory-efficient when dealing with large amounts of primitive data. However,
        they are not a part of the standard Java libraries and need to be added as dependencies to your project.
        */
    }
}
