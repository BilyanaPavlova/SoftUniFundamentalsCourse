package Ex5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bombNumbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bomb = bombNumbers[0];
        int power = bombNumbers[1];

        boolean isBombNumber = true; // 0 1 2 3 4 5 6 7 8

        while (isBombNumber) {

            for (int num: numbers) {
                if(num == bomb)   {
                    int bombIndex = numbers.indexOf(num);
                    int start = bombIndex - power;
                    int end = bombIndex + power;
                    if (start >= 0 && end < numbers.size()) {
                        List<Integer> integers = numbers.subList(start, end + 1);
                        integers.clear();
                        break;
                    }else if(start < 0 && end > numbers.size()-1){
                        start = 0;
                        end = numbers.size()-1;
                        List<Integer> integers = numbers.subList(start, end);
                        integers.clear();
                        numbers.remove(numbers.size()-1);
                        break;
                    }else if (start > 0 && end > numbers.size()-1){
                        end = numbers.size()-1;
                        List<Integer> integers = numbers.subList(start, end);
                        integers.clear();
                        numbers.remove(numbers.size()-1);
                        break;
                    }else if(start < 0 && end < numbers.size()-1){
                        start = 0;
                        List<Integer> integers = numbers.subList(start, end + 1);
                        integers.clear();
                        break;
                    }
                }

            }

            for (int num: numbers) {
                if(num != bomb){
                    isBombNumber = false;
                } else {
                    isBombNumber = true;
                    break;
                }
            }
        }

        int sum = 0;
        for (int num :
                numbers) {
            sum += num;
        }

        System.out.println(sum);
//        System.out.println(numbers);




    }
}