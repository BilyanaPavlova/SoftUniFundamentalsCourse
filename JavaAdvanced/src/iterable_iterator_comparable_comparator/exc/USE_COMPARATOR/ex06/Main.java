package iterable_iterator_comparable_comparator.exc.USE_COMPARATOR.ex06;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Set<Person> peopleByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleByAge = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            peopleByName.add(person);
            peopleByAge.add(person);

        }

        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);
    }
}

/**
 * A `TreeSet` in Java has the following characteristics:
 *
 * 1. **Ordering**: `TreeSet` is an ordered collection. It uses a Red-Black tree structure, and all elements are sorted according to their natural ordering, or by a `Comparator` provided at set creation time, depending on which constructor is used.
 *
 * 2. **Non-Duplicates**: `TreeSet` doesn't allow duplicate elements. That means it only contains unique elements.
 *
 * 3. **Null Elements**: `TreeSet` doesn't allow null elements. Adding null elements into `TreeSet` will throw a `NullPointerException`.
 *
 * 4. **Performance**: Operations like add, remove, and search take `O(log(n))` time.
 *
 * 5. **Non-Synchronized**: `TreeSet` is not synchronized. If multiple threads access a tree set concurrently, and at least one of the threads modifies the set, it must be synchronized externally.
 *
 * Here is a simple example of a `TreeSet` in Java:
 *
 * ```java
 * import java.util.TreeSet;
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         TreeSet<String> treeSet = new TreeSet<>();
 *         treeSet.add("Apple");
 *         treeSet.add("Orange");
 *         treeSet.add("Banana");
 *
 *         // Elements are sorted in ascending order
 *         System.out.println(treeSet); // Output: [Apple, Banana, Orange]
 *     }
 * }
 * ```
 *
 * In this example, a `TreeSet` of `String` objects is created. The `TreeSet` automatically sorts its elements in ascending order.
 */

/**
 * give me example of this: all elements are sorted according to their natural ordering,
 * or by a Comparator provided at set creation time, depending on which constructor is used.
 *
 * Sure, I can provide examples for both cases:
 * sorting according to natural ordering and sorting using a `Comparator`.
 *
 * **Natural Ordering**
 *
 * In Java, natural ordering is the ordering provided by the `Comparable` interface. For example, `String` and `Integer` classes implement `Comparable` and have natural ordering. Here's an example using `TreeSet` with `String`:
 *
 * ```java
 * import java.util.TreeSet;
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         TreeSet<String> treeSet = new TreeSet<>();
 *         treeSet.add("Orange");
 *         treeSet.add("Apple");
 *         treeSet.add("Banana");
 *
 *         System.out.println(treeSet); // Output: [Apple, Banana, Orange]
 *     }
 * }
 * ```
 *
 * In this example, the `TreeSet` automatically sorts the `String` objects in alphabetical order,
 * which is their natural ordering.
 *
 * **Using a Comparator**
 *
 * A `Comparator` can be used to define a custom ordering at the time of `TreeSet` creation.
 * Here's an example where a `TreeSet` is created with a `Comparator` that sorts `String` objects
 * in reverse alphabetical order:
 *
 * ```java
 * import java.util.Comparator;
 * import java.util.TreeSet;
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
 *         treeSet.add("Orange");
 *         treeSet.add("Apple");
 *         treeSet.add("Banana");
 *
 *         System.out.println(treeSet); // Output: [Orange, Banana, Apple]
 *     }
 * }
 * ```
 *
 * In this example, the `TreeSet` sorts the `String` objects in reverse alphabetical order,
 * as defined by the `Comparator`.
 */
