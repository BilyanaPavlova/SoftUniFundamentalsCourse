package FunctionalProgramming.Lec;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NOTES_differences_between_data_structures {
/*
Does all methods of the collections allow for functional programming?

* Not all methods of the Java Collections Framework inherently support
functional programming paradigms like map, filter, reduce, etc.
However, starting from Java 8, many collections provide support for functional programming
through the Stream API.

The Stream API allows you to perform functional-style operations on collections,
such as mapping, filtering, reducing, and more.
Here are some key methods provided by the Stream API:

map: Transforms each element of the stream using the provided function.
filter: Selects elements from the stream that match a given predicate.
reduce: Performs a reduction operation on the elements of the stream.
forEach: Performs an action for each element of the stream.
collect: Accumulates elements into a collection.
flatMap: Transforms each element of the stream into a stream of values and flattens the result.
sorted: Sorts the elements of the stream.
distinct: Removes duplicate elements from the stream.
These methods allow you to express common operations on collections in a functional style.
They enable you to write more concise, expressive, and declarative code compared
to traditional imperative programming.

Here's an example of using the Stream API to perform functional-style operations on a List:
* */


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Map: Square each element
        List<Integer> squares = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        // Filter: Select even numbers
        List<Integer> evens = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        // Reduce: Sum of all elements
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("Squares: " + squares); // Output: Squares: [1, 4, 9, 16, 25]
        System.out.println("Evens: " + evens);     // Output: Evens: [2, 4]
        System.out.println("Sum: " + sum);         // Output: Sum: 15


        /*
         * In this example, we use map to square each element, filter to select even numbers,
         *  and reduce to calculate the sum of all elements.
         * These operations are performed in a functional style using the Stream API.*/

        //--------------Arrays-------------------

    /*
    * is an array a collection?
    *
    * In Java, an array is not considered a part of the Java Collections Framework.
    * While arrays and collections share similarities in that they both hold multiple elements,
    *  they have different characteristics and behaviors.

Here are some key differences between arrays and collections:

1. **Mutability**:
   - Arrays have a fixed size, which is determined at the time of creation, and cannot be changed later.
   * Once an array is created, its size cannot be altered.
   - Collections, on the other hand, are dynamic in size. They can grow or shrink as elements are added or removed.

2. **Generics**:
   - Arrays in Java can hold elements of a specific type, but they do not support generics in the same way that collections do.
   * They can hold primitive types or objects, but the type must be specified at compile time.
   - Collections support generics, allowing you to specify the type of elements they can hold at compile time.
   * This provides type safety and allows for more flexible and generic code.

3. **Methods and Features**:
   - Arrays provide a limited set of methods and features for manipulation.
   * For example, they have length property for size retrieval, but they lack methods like add, remove,
   * and many others that are present in collections.
   - Collections offer a rich set of methods and features for manipulation,
   * such as adding, removing, searching, sorting, iterating, and more.

Despite these differences, arrays can still be used to store and manipulate multiple elements in Java,
* and they are commonly used in various scenarios. However, when more advanced manipulation or flexibility is required,
* collections from the Java Collections Framework are often preferred due to their richer feature set and dynamic nature.
    *
    *
    * can we use functional programming on arrays?
    *
    * Yes, starting from Java 8, you can use functional programming paradigms on arrays using the Stream API.
    * The Stream API allows you to perform functional-style operations on arrays,
    * such as mapping, filtering, reducing, and more.

Here's an example of using functional programming on an array:
    * */

        int[] nums = {1, 2, 3, 4, 5};

        // Map: Square each element
        int[] squares1 = Arrays.stream(nums)
                .map(x -> x * x)
                .toArray();

        // Filter: Select even numbers
        int[] evens1 = Arrays.stream(nums)
                .filter(x -> x % 2 == 0)
                .toArray();

        // Reduce: Sum of all elements
        int sum1 = Arrays.stream(nums)
                .reduce(0, Integer::sum);

        // Print results
        System.out.println("Squares: " + Arrays.toString(squares1)); // Output: Squares: [1, 4, 9, 16, 25]
        System.out.println("Evens: " + Arrays.toString(evens1));     // Output: Evens: [2, 4]
        System.out.println("Sum: " + sum1);                         // Output: Sum: 15


//        /*
//        In this example:
//
// - We use the Arrays.stream() method to create a stream from the array.
// - We perform functional-style operations such as map, filter, and reduce on the stream.
// - Finally, we collect the results back into an array using the toArray() method.
//
// The Stream API provides a powerful and concise way to work with arrays using functional programming paradigms.
// It allows you to write expressive and declarative code for array manipulation.
//        */

        /*
        *
        * can we use functional programing on String?
        *
        * Yes, you can use functional programming paradigms on strings in Java,
        * especially when working with the Stream API introduced in Java 8.
        * The Stream API allows you to perform functional-style operations on strings,
        * such as mapping, filtering, reducing, and more.

Here's an example of using functional programming on a String:

*/
        String str = "Hello World";

        // Map: Convert each character to uppercase
        String upperCase = str.chars()
                              .mapToObj(c -> (char) c)
                              .map(Character::toUpperCase)
                              .map(String::valueOf)
                              .collect(Collectors.joining());

        // Filter: Select only vowels
        String vowels = str.chars()
                           .mapToObj(c -> (char) c)
                           .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                           .map(String::valueOf)
                           .collect(Collectors.joining());

        // Reduce: Concatenate all characters
        String concatenated = str.chars()
                                 .mapToObj(c -> (char) c)
                                 .map(String::valueOf)
                                 .reduce("", String::concat);

        // Print results
        System.out.println("Uppercase: " + upperCase);     // Output: Uppercase: HELLO WORLD
        System.out.println("Vowels: " + vowels);           // Output: Vowels: eo
        System.out.println("Concatenated: " + concatenated); // Output: Concatenated: Hello World

/*In this example:

- We use the `chars()` method of String to convert the string into an IntStream of character values.
- We perform functional-style operations such as map, filter, and reduce on the IntStream.
- Finally, we collect the results back into a string using the `collect()` method with `Collectors.joining()`.

The Stream API provides a convenient and powerful way to work with strings using functional programming paradigms, allowing you to write expressive and concise code for string manipulation.
        *
        * */

        /*
        * Which data structures allow for duplicates in Java?
        *
        * Several data structures in Java allow duplicates:

1. **List**: Lists, such as ArrayList, LinkedList, and Vector, allow duplicates.
* You can add the same element multiple times to a List, and it will maintain the order of insertion.

2. **Queue**: Queues, such as LinkedList and ArrayDeque, allow duplicates.
* When you add elements to a Queue, duplicates are permitted, and they are maintained in the order in which they were added.

3. **Stack**: Stacks, such as Stack or using Deque as a Stack, allow duplicates.
* When you push elements onto a Stack, duplicates are permitted, and they are maintained in the order in which they were added.

4. **Map**: Maps, such as HashMap, LinkedHashMap, TreeMap, and ConcurrentHashMap, allow duplicate values but not duplicate keys.
* Each key in a Map must be unique, but different keys can be associated with the same value.

5. **Multiset**: A Multiset (also known as a Bag) is a specialized collection that allows duplicate elements like a Set,
* but it also allows elements to have a multiplicity greater than 1.
* Libraries like Google Guava provide implementations of Multiset in Java.

6. **SortedSet**: SortedSets, such as TreeSet, allow duplicates if you provide a custom comparator that considers elements equal.

These data structures allow duplicates based on their specific characteristics and requirements.
* Depending on your use case, you can choose the appropriate data structure that fits your needs.
* --------------------!!!!!--------------
* SET - A Set in Java does NOT allow duplicate elements. Each element in a Set must be unique.
* If you attempt to add a duplicate element to a Set, it will simply IGNORE the duplicate and not add it to the Set.
* This ensures that Sets maintain a collection of unique elements.
* This behavior ensures that Sets maintain a collection of unique elements,
* which is useful in many scenarios where uniqueness is a requirement.*/

        /*In Java, the Map interface and its implementations such as HashMap, TreeMap, and LinkedHashMap do not allow for duplicate keys.
        If you try to insert a key-value pair with a key that already exists in the map,
        the old value for that key is replaced with the new value.
         */

    }
}

