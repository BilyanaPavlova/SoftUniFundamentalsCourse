package Ex6_Classes.personPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Person> persons = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String[]input = sc.nextLine().split(" ");
//            Person person = new Person(input[0], Integer.parseInt(input[1]));
//        persons.add(person;
//        }

        ListIterator<Person> personListIterator = persons.listIterator();
        for (int i = 0; i < n; i++) {
            String[]input = sc.nextLine().split(" ");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            personListIterator.add(new Person(input[0], Integer.parseInt(input[1])));
        }

        List<Person> over30 = persons.stream()
                .filter(person -> person.getAge() > 30)
                .collect(Collectors.toList());

        ListIterator<Person> personListIterator1 = over30.listIterator();
        while(personListIterator1.hasNext()){
            System.out.print(personListIterator1.next().toString());
        }
    }
}
