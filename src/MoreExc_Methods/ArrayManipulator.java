package MoreExc_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = sc.nextLine();
        while (!command.equals("end")) {

            if (command.contains("exchange")) {
                exchange(command, numbers);
                System.out.println(Arrays.toString(numbers));
            } else if (command.contains("max odd")) {
                System.out.println(returnIndexOfMaxOdd(numbers));
            } else if (command.contains("max even")) {
                System.out.println(returnIndexOfMaxEven(numbers));
            } else if (command.contains("min odd")) {
                System.out.println(returnIndexOfMinOdd(numbers));
            }else if (command.contains("min even")) {
                System.out.println(returnIndexOfMinEven(numbers));
            }else if(command.contains("first") && (command.contains("even"))){
                returnFirst(command, "even", numbers);
            }else if(command.contains("first") && (command.contains("odd"))){
                returnFirst(command, "odd", numbers);
            }

            numbers = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            command = sc.nextLine();
        }
    }

    private static int returnCommandIndex(String command, int i) {
        String[] commandArr = command.split(" ");
        int commandIndex = Integer.parseInt(commandArr[i]);
        return commandIndex;
    }

    public static void returnFirst(String command, String evenOrOdd, int [] numbers) {

//            If the count is greater than the array length, print "Invalid count".
        if (returnCommandIndex(command, 1) > numbers.length || (returnCommandIndex(command, 1) < 0)) {
            System.out.println("Invalid count");

        } else if (returnCommandIndex(command, 1) == 0){
            System.out.println("[]");

        } else if (evenOrOdd.equals("even")) {

                int numberOfFirstNumbers = returnCommandIndex(command, 1);
                int count = 0;
                int newArr[] = new int[numberOfFirstNumbers];
                for (int i = 0; i < numbers.length; i++) {

                    if (numbers[i] % 2 == 0) {
                        newArr[count] = numbers[i];

                        count++;
                    }
                }

                if(count < numberOfFirstNumbers){
                    for (int i = 0; i < count; i++) {
                        System.out.print(newArr[i] + " ");
                    }

                }else {
                    System.out.println(Arrays.toString(newArr));
                };
            } else if (evenOrOdd.equals("odd")) {
                int numberOfFirstNumbers = returnCommandIndex(command, 1);
                int count = 0;
                int[] newArr = new int[numberOfFirstNumbers];
                for (int i = 0; i < numbers.length; i++) {

                    if (numbers[i] % 2 != 0) {
                        newArr[count] = numbers[i];
                        count++;
                    }
                    if (count == numberOfFirstNumbers) {
                        break;
                    }
                }
                System.out.println(Arrays.toString(newArr));
            }

        }



    public static int returnIndexOfMinOdd (int[]numbers){
        int temp = Integer.MAX_VALUE;
        int ind = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 != 0){
                if (numbers[i] <= temp){
                    temp = numbers[i];
                    ind = i;
                }
            }
        }
        return ind;
    }

    public static int returnIndexOfMinEven (int[]numbers){
        int temp = Integer.MAX_VALUE;
        int ind = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 == 0){
                if (numbers[i] <= temp){
                    temp = numbers[i];
                    ind = i;
                }
            }
        }
        return ind;
    }

//    1 2 3 4 2 4 5 -> 4(5)
    public static int returnIndexOfMaxEven(int [] numbers){
        int temp = Integer.MIN_VALUE;
        int ind = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 == 0){
                if (numbers[i] >= temp){
                    temp = numbers[i];
                    ind = i;
                }
            }
        }
        return ind;
    }




    public static void exchange(String command, int[] numbers) {
//        String[] commandArr = command.split(" ");
//        int index = Integer.parseInt(commandArr[1]);
        int index = returnCommandIndex(command, 1);

//                3 4 5 6 7
//                0 1 2 3 4
        int [] temp = new int[numbers.length - index - 1];
        for (int i = 0; i < temp.length; i++) {
            index++;
            temp[i] = numbers[index];
        }

        for (int i = numbers.length - 2; i >= 0; i--) {
            numbers[i + 1] = numbers[i];

        }

        for (int i = 0; i < temp.length; i++) {
            numbers[i] = temp[i];


        }
    }


    public static int returnIndexOfMaxOdd (int[] numbers){
//max even/odd
//        [1, 4, 8, 2, 3] -> max odd -> print 4

        int temp = Integer.MIN_VALUE;
        int ind = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 != 0){
                if (numbers[i] >= temp){
                    temp = numbers[i];
                    ind = i;
                }
            }
        }
        return ind;

    }


    }

