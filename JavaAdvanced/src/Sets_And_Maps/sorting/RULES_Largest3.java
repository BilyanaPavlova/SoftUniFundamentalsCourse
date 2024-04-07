package Sets_And_Maps.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RULES_Largest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //find the 3 largest
        List<Integer> nums = Arrays
                .stream(sc.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .collect(Collectors.toList());
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
