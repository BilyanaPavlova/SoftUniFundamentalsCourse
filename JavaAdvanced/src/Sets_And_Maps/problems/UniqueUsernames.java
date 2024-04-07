package Sets_And_Maps.problems;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<String> list = new LinkedHashSet<>();

        String name = null;
        for (int i = 0; i < n; i++) {
            name = sc.nextLine();
            list.add(name);
        }

        for (String el :
                list) {
            System.out.println(el);
        }

    }
}

