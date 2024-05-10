package FunctionalProgramming.Lec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lec5_FilterByAge_Filter_Objects {

//    Write a program that reads an integer N on the first line.
//    And on next N lines read pairs of "{name}, {age}". Then read three more lines:
//· Condition - "younger" or "older"
//· Age - Integer
//· Format - "name", "age" or "name age"
//Depending on the condition, print the pairs in the right format.
//Don't use any built-in functionality. Write your methods.



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //define a function to read with the scanner and return a person
        Function<Scanner, Person> readPerson = sc -> {
            //read a line
            String[] data = sc.nextLine().split(", ");
            //initiate a person object
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            return new Person(name, age);
        };

        List<Person> people = new ArrayList<>();

        // read the persons using the function
        while(n-- > 0){

            // call the function to initialise persons
            Person p = readPerson.apply(scanner);
            people.add(p);

        }

        //read the condition, age and format
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        //define Predicates by using functions
        Predicate <Person> ageFilter = getFilter(condition, age);
        Consumer<Person> printer = getPrinter(format);

        // stream on the list
        people.stream()
                .filter(ageFilter)
                .forEach(printer);

    }

    //define function getFilter to return Predicate<Person> with different conditions
    private static Predicate <Person> getFilter(String condition, int age){
        switch (condition){
            case "older":
                   return p -> p.age >= age;
            case "younger":
                return p -> p.age <= age;
            default:
                throw new IllegalArgumentException ("Unknown condition " + condition);
        }
    }

    private static Consumer<Person> getPrinter (String format){
        switch (format){
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format " + format);
        }
    }
}
