package MidExamPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberList_withDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        double average = findAverage(numbers);

        List <Integer> biggerThanAverage = findBiggerThanAverage(numbers, average);
        if(biggerThanAverage.isEmpty()){
            System.out.println("No");
            return;
        }

        List<Integer> topFive = findTopFive(biggerThanAverage);


        System.out.println(Arrays.toString(topFive.toArray())
                .replaceAll("[\\[\\],]", ""));

    }

    private static List<Integer> findTopFive(List<Integer> biggerThanAverage) {
        List <Integer> top5 = new ArrayList<>();

        while (true) {

            int biggest = 0;
            //find the biggest
            if(!biggerThanAverage.isEmpty()) {
               biggest = returnBiggestNumber(biggerThanAverage);
            } else {
                break;
            }

            if (top5.size() < 5) {
                //add the biggest from all biggest list to the top5 list
                top5.add(biggest);
            } else {
                break;
            }

            //remove the found number from the biggest list
            for (int i = 0; i < biggerThanAverage.size(); i++) {
                if (biggerThanAverage.get(i) == biggest) {
                    biggerThanAverage.remove(i);

                }
            }
        }

        return top5;
    }

    private static int returnBiggestNumber(List <Integer> numbers){
        int max = numbers.get(0);
        for (int num :
                numbers) {
            if (num >= max) {
                max = num;
            }
        }
        return max;
    }

    public static double findAverage (List<Integer> numbers){
        int sum = 0;
        for (int num :
                numbers) {
            sum += num;
        }

        double average = sum * 1.0 / numbers.size();

        return average;
    }

    public static List<Integer> findBiggerThanAverage(List<Integer>numbers, double average){
        List<Integer> biggerNumbers = new ArrayList<>();
        for (int num :
                numbers) {
            if(average < num){
                biggerNumbers.add(num);
            }
        }
        return biggerNumbers;
    }
}
