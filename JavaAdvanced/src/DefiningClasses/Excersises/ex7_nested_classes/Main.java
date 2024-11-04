package DefiningClasses.Excersises.ex7_nested_classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        List<Person> people = new LinkedList<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] elements = input.split("\\s+");
            String name = elements[0];

            if (people.isEmpty()){
                people.add(new Person(name));
            }

            boolean exists = people.stream().anyMatch(person -> person.getName().equals(name));

            if (!exists) {
                people.add(new Person(name));
            }

            Person person = people.stream().filter(p -> p.getName().equals(name)).findAny().get();


            switch (elements[1]) {
                case "company":
                    String companyName = elements[2];
                    String department = elements[3];
                    double salary = Double.parseDouble(elements[4]);
                    person.setCompany(companyName, department, salary);
//                    Person.Company company = person.new Company(companyName, department, salary);
                    break;
                case "pokemon":
                    String pokemonName = elements[2];
                    String type = elements[3];
                    person.addPokemon(pokemonName, type);
//                    Person.Pokemon pokemon = new Person.Pokemon(pokemonName, type);
                    break;
                case "parents":
                    String parentName = elements[2];
                    String parentBirthday = elements[3];
                    person.addParent(parentName, parentBirthday);
//                    Person.Parent parent = new Parent(parentName, parentBirthday);
                    break;
                case "children":
                    String childName = elements[2];
                    String childBirthday = elements[3];
                    person.addChild(childName, childBirthday);
//                    Child child = new Child(childName, childBirthday);
                    break;
                case "car":
                    String model = elements[2];
                    int speed = Integer.parseInt(elements[3]);
                    person.setCar(model, speed);
//                    Car car = new Car(model, speed);
                    break;
            }



            input = sc.nextLine();
        }

        String personName = sc.nextLine();

        people.stream().forEach(p -> {
            if (p.getName().equals(personName)) {
                System.out.println(p);
            }
        });
    }
}
