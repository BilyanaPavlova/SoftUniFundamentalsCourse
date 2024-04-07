package Sets_And_Maps.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class RULES_SortingCollections {
    public static void main(String[] args) {

        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(12);
        hs.add(42);
        hs.add(53);
        hs.add(3);

        //sort in ascending order
        List<Integer> collect = hs.stream()
                .sorted((n1, n2) -> n1.compareTo(n2))
                .collect(Collectors.toList());

        for (int el :
                collect) {
            System.out.print(el + " ");
        }
        System.out.println();

        //sort in descending order
        HashSet<Integer> hs1 = new HashSet<>();
        hs1.add(3);
        hs1.add(56);
        hs1.add(87);
        hs1.add(4);

        List<Integer> collect1 = hs1.stream()
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());
        for (int el :
                collect1) {
            System.out.print(el + " ");
        }



    }

}
