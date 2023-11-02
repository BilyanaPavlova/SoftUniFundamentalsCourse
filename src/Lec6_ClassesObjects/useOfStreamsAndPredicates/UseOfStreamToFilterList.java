package Lec6_ClassesObjects.useOfStreamsAndPredicates;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UseOfStreamToFilterList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> names = Arrays.asList("Bi", "Kra", "Pav");

        String searchedName = names.stream()
                .filter(s -> s.equals("Kram"))
                .findFirst()
                .orElse("not found");

        System.out.println(searchedName);
    }
}
