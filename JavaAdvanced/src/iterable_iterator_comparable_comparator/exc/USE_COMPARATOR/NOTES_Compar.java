package iterable_iterator_comparable_comparator.exc.USE_COMPARATOR;

public class NOTES_Compar {

    /**
     * In Java, `Comparable` and `Comparator` are two interfaces used for comparing objects.
     * Here's a brief overview of each:
     *
     * 1. **Comparable**: This interface is used to order the objects of the user-defined class.
     * It provides a single method, `compareTo(Object)`,
     * which can be implemented by any class to define a natural ordering of its instances.
     * If a class implements `Comparable`, it can be used in sorting methods
     * like `Arrays.sort()` or `Collections.sort()`. Here's an example:
     *
     * ```java
     * public class Person implements Comparable<Person> {
     *     private String name;
     *
     *     // constructor, getters and setters
     *
     *     @Override
     *     public int compareTo(Person other) {
     *         return this.name.compareTo(other.getName());
     *     }
     * }
     * ```
     *
     * In this example, `Person` objects can be sorted by their `name` property.
     *
     * 2. **Comparator**: This interface is used to order the objects of user-defined classes.
     * It provides two methods: `compare(Object, Object)` and `equals(Object)`.
     * A class doesn't need to implement `Comparator` to be able to use it.
     * Instead, you can create a `Comparator` for a class and pass it to a sorting method.
     * This allows for more flexible sorting, as you can have different `Comparator`s for different sort orders.
     * Here's an example:
     *
     * ```java
     * public class AgeComparator implements Comparator<Person> {
     *     @Override
     *     public int compare(Person p1, Person p2) {
     *         return Integer.compare(p1.getAge(), p2.getAge());
     *     }
     * }
     * ```
     *
     * In this example, `Person` objects can be sorted by their `age` property using an `AgeComparator`.
     *
     * In summary, use `Comparable` if you need a single, natural ordering for your class. Use `Comparator` if you need multiple different orderings.
     */

    /**
     * USE with sorting methods like `Arrays.sort()` or `Collections.sort()`:
     *
     * To use `Comparable` and `Comparator` in Java, you typically use them in conjunction with sorting methods
     * like `Arrays.sort()` or `Collections.sort()`. Here's how you can do it:
     *
     * For `Comparable`:
     *
     * ```java
     * public class Person implements Comparable<Person> {
     *     private String name;
     *
     *     // constructor, getters and setters
     *
     *     @Override
     *     public int compareTo(Person other) {
     *         return this.name.compareTo(other.getName());
     *     }
     * }
     *
     * // somewhere else in your code
     * Person[] people = // an array of Person objects
     * Arrays.sort(people);
     * ```
     *
     * In this example, the `Person` class implements `Comparable<Person>`,
     * and overrides the `compareTo` method to specify that `Person` objects should be sorted
     * by their `name` property. Then, you can sort an array of `Person` objects using `Arrays.sort()`.
     *
     * For `Comparator`:
     *
     * ```java
     * public class AgeComparator implements Comparator<Person> {
     *     @Override
     *     public int compare(Person p1, Person p2) {
     *         return Integer.compare(p1.getAge(), p2.getAge());
     *     }
     * }
     *
     * // somewhere else in your code
     * Person[] people = // an array of Person objects
     * Arrays.sort(people, new AgeComparator());
     * ```
     *
     * In this example, the `AgeComparator` class implements `Comparator<Person>`,
     * and overrides the `compare` method to specify that `Person` objects should be sorted by their `age` property.
     * Then, you can sort an array of `Person` objects using `Arrays.sort()`,
     * passing in a new instance of `AgeComparator` as the second argument.
     */

    /**
     * Sure, here's how you can use `Comparable` and `Comparator` with `Collections.sort()` in Java:
     *
     * First, let's define a `Person` class that implements `Comparable`:
     *
     * ```java
     * public class Person implements Comparable<Person> {
     *     private String name;
     *
     *     // constructor, getters and setters
     *
     *     @Override
     *     public int compareTo(Person other) {
     *         return this.name.compareTo(other.getName());
     *     }
     * }
     * ```
     *
     * You can then use `Collections.sort()` to sort a list of `Person` objects:
     *
     * ```java
     * List<Person> people = // a list of Person objects
     * Collections.sort(people);
     * ```
     *
     * Now, let's define a `Comparator` for `Person`:
     *
     * ```java
     * public class AgeComparator implements Comparator<Person> {
     *     @Override
     *     public int compare(Person p1, Person p2) {
     *         return Integer.compare(p1.getAge(), p2.getAge());
     *     }
     * }
     * ```
     *
     * You can use this `Comparator` with `Collections.sort()` to sort a list of `Person` objects by age:
     *
     * ```java
     * List<Person> people = // a list of Person objects
     * Collections.sort(people, new AgeComparator());
     * ```
     *
     * In the first example, the `Person` objects are sorted by their `name` property, as defined by the `compareTo` method in the `Person` class. In the second example, the `Person` objects are sorted by their `age` property, as defined by the `compare` method in the `AgeComparator` class.
     */
}
