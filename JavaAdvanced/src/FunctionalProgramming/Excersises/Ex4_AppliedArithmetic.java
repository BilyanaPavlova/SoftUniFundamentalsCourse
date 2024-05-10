package FunctionalProgramming.Excersises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex4_AppliedArithmetic {

//    On the first line, you are given a list of numbers. On the next lines you are passed different commands
//    that you need to apply to all numbers in the list:
//    "add" -> adds 1; "multiply" -> multiplies by 2; "subtract" -> subtracts 1; "print" -> prints all numbers on a new line.
//    The input will end with an "end" command, after which the result must be printed.
//    input:
//    1 2 3 4 5
//add
//add
//print
//end
//    output:
//    3 4 5 6 7

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //different conversions of Strings to int[], List, or int:

        int[] intArray = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


//        List<Integer> intList = Arrays.stream(sc.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .toList();
//
//        int sum1 =Arrays.stream(sc.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .mapToInt(Integer::intValue)
//                .sum();
//
//        int sum2 = Arrays.stream(sc.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .sum();


        String command = sc.nextLine();

        while(!command.equals("end")){
            switch (command) {
                case "add":
                    intArray = Arrays.stream(intArray).map(n -> n + 1).toArray();
                    break;
                case "multiply":
                    intArray = Arrays.stream(intArray).map(n -> n * 2).toArray();
                    break;
                case"subtract":
                    intArray = Arrays.stream(intArray).map(n -> n - 1).toArray();
                    break;
                case "print":
                    Arrays.stream(intArray).forEach(n -> System.out.print( n + " "));
                    break;
            }
            command = sc.nextLine();
        }
    }
}
