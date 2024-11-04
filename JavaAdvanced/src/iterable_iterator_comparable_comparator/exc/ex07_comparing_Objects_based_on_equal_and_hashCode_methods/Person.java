package iterable_iterator_comparable_comparator.exc.ex07_comparing_Objects_based_on_equal_and_hashCode_methods;

import java.util.Objects;

public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    //nesessary to initially position and compare the objects in the HashSet
    @Override
    public boolean equals(Object other) {
        if (this == other) return true; // if references are equal
        if (other == null || getClass() != other.getClass()) return false; // if other is null or class types are different
        Person person = (Person) other; // cast other to Person
        return age == person.age && name.equals(person.name); // return true if age and name are equal
    }

    //nesessary to initially position and compare the objects in the HashSet
    @Override
    public int hashCode() {
        return Objects.hash(name, age); // return hash of the object based on name and age
    }

    //necessary to compare and initially position the objects in the TreeSet
    @Override
    public int compareTo( Person other) {
        int result = this.getName().compareTo(other.getName()); //use of compareTo of String, String is Comparable by default
        if (result == 0) {
            result = Integer.compare(this.getAge(), other.getAge()); // uses Integer comparator
        }
        return result;
    }
}
