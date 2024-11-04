package iterable_iterator_comparable_comparator.exc.ex05_Comparable;



import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();

        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            list.add(person);

            input = sc.nextLine();
        }

        int idxTarget = Integer.parseInt(sc.nextLine());
        Person targetPerson = list.get(idxTarget - 1);

        int equalCount = 0;
        int notEqualCount = 0;

        for (Person person : list) {
            if (targetPerson.compareTo(person) == 0) {
                equalCount++;
            } else {
                notEqualCount++;
            }
        }

        int totalPeople = list.size();

        if (equalCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equalCount, notEqualCount, totalPeople);
    }


    }
}
