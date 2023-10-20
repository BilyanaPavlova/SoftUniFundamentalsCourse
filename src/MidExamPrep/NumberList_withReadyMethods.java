package MidExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class NumberList_withReadyMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        for (int num :
                numbers) {
            sum += num;
        }

        double average = sum * 1.0 / numbers.size();




        List<Integer> biggerThanAverage = new ArrayList<>();
        for (int num :
                numbers) {
            if(average < num){
                biggerThanAverage.add(num);
            }
        }

        if (biggerThanAverage.isEmpty()) {
            System.out.println("No");
            return;
        }

//        The method doesn't return anything because it directly modifies the original list provided as an argument.
      Collections.sort(biggerThanAverage);
        Collections.reverse(biggerThanAverage);

        if (biggerThanAverage.size() > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(biggerThanAverage.get(i) + " ");
            }

        }else {
            System.out.println(Arrays.toString(biggerThanAverage.toArray())
                    .replaceAll("[\\[\\],]", ""));
        }

    }

}
