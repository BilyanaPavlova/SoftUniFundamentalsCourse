package Lec5_Lists;

import java.util.*;

public class PrintList {
    public static void main(String[] args) {

        // print with a lambda expression

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // Print elements using forEach() and lambda expression
        System.out.println("List Elements:");
        list.forEach(element -> System.out.println(element));


        // print with an array

        System.out.println("List Elements:");
        for (String element : list) {
            System.out.println(element);

        }
    }
}