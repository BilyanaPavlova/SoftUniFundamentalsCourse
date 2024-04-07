package Sets_And_Maps.problems;

import java.util.*;
import java.util.stream.Collectors;

public class P03_PeriodicTaple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        // with sorting:
//        Set<String> set = new HashSet<>();
//
//        String[] arr = null;
//
//        for (int i = 0; i < n; i++) {
//            arr = sc.nextLine().split("\\s+");
//            for (int j = 0; j < arr.length; j++) {
//                set.add(arr[j]);
//            }
//
//        }
//
//        LinkedHashSet<String> collected = set.stream()
//                .sorted((el1, el2) -> el1.compareTo(el2))
//                .collect(Collectors.toCollection(LinkedHashSet::new));
//        for (String el :
//                collected) {
//            System.out.print(el + " ");
//        }


        //without sorting - but with a sorted TreeSet
        Set<String> set = new TreeSet<>();
//
        String[] arr = null;
        for (int i = 0; i < n; i++) {
            arr = sc.nextLine().split("\\s+");
            for (int j = 0; j < arr.length; j++) {
                set.add(arr[j]);
            }

        }

        for (String el :
                set) {
            System.out.print(el + " ");
        }

    }
}