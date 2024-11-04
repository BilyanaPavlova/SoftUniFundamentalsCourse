package DefiningClasses.Excersises.ex7_nested_classes;

import java.util.ArrayList;
import java.util.List;

/**
 * In this solution, each type of information (Company, Car, Parent, Child, Pokemon)
 * is represented as a nested class within the Person class.
 * This allows you to encapsulate the details of each type of information within its own class,
 * while still keeping everything within the context of a Person.

 Nested classes in Java are used for various reasons:

 1. Logical Grouping: If a class is useful to only one other class,
 then it is logical to embed it in that class and keep the two together.
 This makes the code more readable and maintainable.

 2. Increased Encapsulation: Consider two top-level classes, A and B, where B needs access to members of A
 that would otherwise be declared private. By hiding class B within class A,
 A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.

 3. More Readable, Maintainable Code: Nesting small classes within top-level classes places the code closer to where it is used.
 */

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    class Company {
        private String name;
        private String department;
        private double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    class Car {
        private String model;
        private int speed;

        public Car(String model, int speed) {
            this.model = model;
            this.speed = speed;
        }
    }

    class Pokemon {
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    class Parent {
        private String name;
        private String birthday;

        public Parent(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    }

    class Child {
        private String name;
        private String birthday;

        public Child(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    }

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(String name, String department, double salary) {
        this.company = new Company(name, department, salary);
    }

    public void setCar(String model, int speed) {
        this.car = new Car(model, speed);
    }

    public void addPokemon(String name, String type) {
        this.pokemons.add(new Pokemon(name, type));
    }

    public void addParent(String name, String birthday) {
        this.parents.add(new Parent(name, birthday));
    }

    public void addChild(String name, String birthday) {
        this.children.add(new Child(name, birthday));
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company.name).append(" ").append(this.company.department).append(" ").append(String.format("%.2f", this.company.salary)).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car.model).append(" ").append(this.car.speed).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());

        this.pokemons.forEach(pokemon -> sb.append(pokemon.name).append(" ").append(pokemon.type).append(System.lineSeparator()));
//        for (Pokemon pokemon : pokemons) {
//            sb.append(pokemon.name).append(" ").append(pokemon.type).append(System.lineSeparator());
//        }
        sb.append("Parents:").append(System.lineSeparator());
        this.parents.forEach(parent -> sb.append(parent.name).append(" ").append(parent.birthday).append(System.lineSeparator()));
//        for (Parent parent : parents) {
//            sb.append(parent.name).append(" ").append(parent.birthday).append(System.lineSeparator());
//        }
        sb.append("Children:").append(System.lineSeparator());
        this.children.forEach(child -> sb.append(child.name).append(" ").append(child.birthday).append(System.lineSeparator()));
//        for (Child child : children) {
//            sb.append(child.name).append(" ").append(child.birthday).append(System.lineSeparator());
//        }
        return sb.toString();
    }

/*
* The child.birthday notation is used to directly access the birthday field of the Child class.
* This is possible because the toString() method is within the Person class, and the Child class is an inner class of Person.
* In Java, an outer class has access to the fields and methods of its inner classes, even if they are private.
*
* However, it's generally considered good practice to use getter methods to access fields, especially if they are private.
* This is because getter methods can provide a level of abstraction between the class's internal representation
* and the outside world. They can also allow for additional logic to be added in the future,
* such as validation or transformation.  If you want to use the getter method,
* you would need to create one in the Child class, like so:
*
* class Child {
    private String name;
    private String birthday;

    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }
}
*
* Then, you can use child.getBirthday() in your toString() method:
*
* this.children.forEach(child -> sb.append(child.getName()).append(" ")
* .append(child.getBirthday()).append(System.lineSeparator()));
* */







}
