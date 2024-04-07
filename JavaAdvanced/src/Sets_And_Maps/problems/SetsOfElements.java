package Sets_And_Maps.problems;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = arr[0];
        int m = arr[1];

        Set<Integer> setN = new LinkedHashSet<>();
        Set<Integer> setM = new LinkedHashSet<>();
        Set<Integer> repeated = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            setN.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            setM.add(Integer.parseInt(sc.nextLine()));
        }

        for (int el :
                setN) {
            if(setM.contains(el)){
                repeated.add(el);
            }
        }

        for (int el :
                repeated) {
            System.out.print(el + " ");
        }


    }
}
