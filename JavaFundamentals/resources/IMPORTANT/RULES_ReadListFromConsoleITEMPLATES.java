package resources.IMPORTANT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RULES_ReadListFromConsoleITEMPLATES {
    public static void main(String[] args) {
        /*
         * To read a List from the console in Java,
         * you can use a loop to continuously read input from the console and add the elements to a List
         * until the user decides to stop inputting.
         */

        Scanner sc = new Scanner(System.in);

        List<Integer> integerList = new ArrayList<>();

        System.out.println("Enter integers (enter a non-integer to stop):");

        // Read integers from the console until a non-integer is entered

        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            integerList.add(number);
        }

        System.out.println("List of Integers: " + integerList);

        // Read a line of integers from the console
        System.out.print("Enter integers separated by space: ");
        String inputLine = sc.nextLine();

        // Split the input line into individual integers
        String[] integerStrings = inputLine.split("\\s+");

        // Parse and add integers to the list
        List<Integer> integList = new ArrayList<>();
        for (String integerString : integerStrings) {
            try {
                int number = Integer.parseInt(integerString);
                integList.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + integerString + " is not an integer.");
            }
        }

        // Print the list of integers
        System.out.println("List of Integers: " + integList);


//In this example:
//
//        scanner.nextLine() reads the entire line of input from the console.
//        inputLine.split("\\s+") splits the input line into individual strings based on spaces (or any whitespace characters).
//        The for loop iterates through the array of strings, attempts to parse each string as an integer, and adds valid integers to the integerList.
//        If a string cannot be parsed into an integer (due to non-integer input), it catches NumberFormatException and prints an error message.
//        This code allows the user to input integers separated by spaces on a single line, and it adds these integers to a List for further processing.

//-------------------
//read using streams and map(Integer::parseInt) and collection

        // Split the input line into individual strings, parse to integers, and collect into a list
        String input1 = sc.nextLine();

        List<Integer> intList = Arrays.stream(input1.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

//live templates
        // listInt + enter = list of integers from the console
        //intArr + enter = array of integers from the console


    }
}


