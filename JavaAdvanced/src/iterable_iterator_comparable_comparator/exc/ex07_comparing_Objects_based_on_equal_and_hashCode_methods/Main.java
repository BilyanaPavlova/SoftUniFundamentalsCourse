package iterable_iterator_comparable_comparator.exc.ex07_comparing_Objects_based_on_equal_and_hashCode_methods;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Person> peopleTreeSet = new TreeSet<>();
        HashSet<Person> peopleHashSet = new HashSet<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            peopleTreeSet.add(person);
            peopleHashSet.add(person);
        }

        System.out.println(peopleTreeSet.size());
        System.out.println(peopleHashSet.size());

    }
}
