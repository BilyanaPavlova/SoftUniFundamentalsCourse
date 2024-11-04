package iterable_iterator_comparable_comparator.lec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// това, което можем да итерираме имплементира Iterable, за да можем да го итерираме
// нещото, с което итерираме е Itearator, който имплементира hasNext() и next()
// итератора е вътрешен клас на класа, който итерираме и имплементира Iterator интерфейса
// итераторът се връша от метода iterator() на класа, който итерираме, и който трябва да е Iterable

public class NOTES_ITERATOT_EXPLANATION {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        //each list has it's iterator method,
        // that returns an object of type Iterator,
        // that holds reference to a current element in the list
        //and iterates over the list in proper sequence (natural order)
        Iterator<String> iterator = list.iterator();

//iterator has 3 methods:
        boolean b = iterator.hasNext();
        String currentElement = iterator.next();
        iterator.remove(); //removes the current element
        iterator.forEachRemaining(e-> System.out.println(e));

        for(String s : list){
            System.out.println(s);
        }

        //iterator is a pointer to the current element in the list

        //if I want to override the iterator method, I can do it by wrapping the list in a class
        //and overriding the iterator method in that class so that I can iterate over the list in a different way
        //for example, I can iterate over the list in reverse order
        //or I can iterate over the list in a random order

        //I can also create a custom iterator class that implements the Iterator interface
        //and override the hasNext() and next() methods

        //where I call an iterator?

        //The iterator is called automatically in the `Main.java` file where you have the for-each loop.
        // Here's the relevant part of the code:
        //
        //```java
        //Lake lake = new Lake(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //for (Integer position : lake) {
        //    System.out.print(position + " ");
        //}
        //```
        //
        //In this code, `lake` is an instance of the `Lake` class, which implements `Iterable<Integer>`.
        // When you use a for-each loop (`for (Integer position : lake)`), it automatically calls the `iterator()` method
        // on the `lake` object. This method returns an instance of the `Frog` class,
        // which implements `Iterator<Integer>`.
        // The for-each loop then uses this iterator to iterate over the positions in the lake.

        //----

        //What is the difference between an iterator and a for-each loop?

        //The for-each loop is a shorthand way of iterating over a collection of elements,
        //it uses an iterator behind the scenes to traverse the collection in a natural order.
        // While an iterator is an object that allows you to traverse a collection of elements
        // and perform operations like adding, removing, or updating elements.

        //does each list has an iterator method?
        //Yes, each instance of `List` in Java has its own `Iterator`.
        // When you call the `iterator()` method on a `List`, it returns a new `Iterator` instance
        // that can be used to iterate over the elements in that list.
        // This `Iterator` is independent of any other iterators that might be created for the same list or for other lists.
        //
        //Here's an example:
        //
        //```java
        //List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        //List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);
        //
        //Iterator<Integer> iterator1 = list1.iterator();
        //Iterator<Integer> iterator2 = list2.iterator();
        //
        //while (iterator1.hasNext()) {
        //    System.out.println(iterator1.next());
        //}
        //
        //while (iterator2.hasNext()) {
        //    System.out.println(iterator2.next());
        //}
        //```
        //
        //In this code, `iterator1` and `iterator2` are separate `Iterator` instances for `list1` and `list2` respectively.
        // Each iterator maintains its own position within its respective list.

        //----

        //how can I create several different iterators for a list?

//        You can create several iterators for a list by simply calling the `iterator()` method on the list multiple times.
//        Each call to `iterator()` returns a new iterator that can be used independently of the others.
//
//Here's an example:
//
//```java
//List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//Iterator<Integer> iterator1 = nums.iterator();
//Iterator<Integer> iterator2 = nums.iterator();
//Iterator<Integer> iterator3 = nums.iterator();
//
//// Now you can use iterator1, iterator2, and iterator3 independently.
//```
//
//In this code, `iterator1`, `iterator2`, and `iterator3` are separate `Iterator` instances for the `nums` list.
// Each iterator maintains its own position within the list.

       //------

        //how to iterate in a different way with each iterator?

        //To iterate in a different way with each iterator, you can create different iterator implementations.
        // Each implementation can define a different way of iterating over the elements of the list.
        //
        //For example, you can create one iterator that iterates over the elements in the normal order,
        // and another iterator that iterates over the elements in reverse order.
        //
        //Here's how you can do it:
        //
        //```java
        //public class CustomList implements Iterable<Integer> {
        //    private List<Integer> list;
        //
        //    public CustomList(List<Integer> list) {
        //        this.list = list;
        //    }
        //
        //    @Override
        //    public Iterator<Integer> iterator() {
        //        return list.iterator();
        //    }
        //
        //    public Iterator<Integer> reverseIterator() {
        //        List<Integer> reverseList = new ArrayList<>(list);
        //        Collections.reverse(reverseList);
        //        return reverseList.iterator();
        //    }
        //}
        //```
        //
        //In this code, `CustomList` is a wrapper around a `List<Integer>`.
        // It provides two methods to get iterators: `iterator()` for normal order iteration,
        // and `reverseIterator()` for reverse order iteration.
        //
//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //You can use it like this:
        //
        //```java
        //CustomList customList = new CustomList(Arrays.asList(1, 2, 3, 4, 5));
        //
        //// Iterate in normal order
        //for (Integer num : customList) {
        //    System.out.print(num + " ");
        //}
        //
        //System.out.println();
        //
        //// Iterate in reverse order
        //Iterator<Integer> reverseIterator = customList.reverseIterator();
        //while (reverseIterator.hasNext()) {
        //    System.out.print(reverseIterator.next() + " ");
        //}
        //```
        //
        //This will print:
        //
        //```
        //1 2 3 4 5
        //5 4 3 2 1
        //```
        //
        //As you can see, the first loop iterates over the elements in the normal order,
        // and the second loop iterates over the elements in reverse order.

        //The reverseIterator() method creates a new list (reverseList) as a copy of the original list (list).
        // This is done to avoid modifying the original list when we call Collections.reverse(reverseList).
        // The Collections.reverse() method reverses the order of elements in the list it operates on.
        // If we directly used the original list, it would have been reversed,
        // affecting its order for any subsequent operations.
        // By creating a copy of the list, we ensure that the original list remains unaffected.
        // The reversed copy is used solely for the purpose of creating a reverse iterator.
        // The iterator returned by reverseIterator() will iterate over the elements of reverseList,
        // which are the elements of the original list in reverse order.

        //---
        //so, we cannot overide the iterator methos of the list itself inside the list class?

        //No, you cannot override the `iterator()` method of the `List` interface within the `List` itself
        // because `List` is an interface in Java's standard library, and its methods are already defined.
        //
        //However, you can create a new class that implements the `Iterable` interface and define your own `iterator()` method
        // in that class. This allows you to control the behavior of the iterator for instances of your class.
        //
        //For example, if you have a class `MyList` that implements `Iterable`, you can define your own `iterator()` method:
        //
        //```java
        //public class MyList implements Iterable<Integer> {
        //    private List<Integer> list;
        //
        //    public MyList(List<Integer> list) {
        //        this.list = list;
        //    }
        //
        //    @Override
        //    public Iterator<Integer> iterator() {
        //        // Your custom iterator implementation here
        //    }
        //}
        //```
        //
        //In this code, `MyList` is a wrapper around a `List<Integer>`.
        // It provides its own `iterator()` method, which can return a custom `Iterator`
        // that behaves in the way you want.

        //----

        // can I use iterator to insert elements in a list and modify it?

        //Yes, you can use the `ListIterator` interface in Java to insert elements into a list while iterating over it.
        // The `ListIterator` extends the `Iterator` interface and provides additional functionality,
        // such as adding elements, replacing elements, and iterating in reverse order.
        //
        //Here's an example of how you can use a `ListIterator` to insert elements into a list:
        //
        //```java
        //import java.util.ArrayList;
        //import java.util.List;
        //import java.util.ListIterator;
        //
        //public class Main {
        //    public static void main(String[] args) {
        //        List<String> list = new ArrayList<>();
        //        list.add("one");
        //        list.add("two");
        //        list.add("three");
        //
        //        ListIterator<String> listIterator = list.listIterator();
        //
        //        while (listIterator.hasNext()) {
        //            String element = listIterator.next(); // current element
        //
        //            // Insert an element before the current element
        //            if (element.equals("two")) {
        //                listIterator.previous(); // moves to the previous element
        //                listIterator.add("one and a half");
        //                listIterator.next();
        //            }
        //        }
        //
        //        System.out.println(list);  // Output: [one, one and a half, two, three]
        //    }
        //}
        //```
        //
        //In this code, we're using a `ListIterator` to iterate over a list of strings.
        // When we encounter the string "two", we move the iterator back one step using `listIterator.previous()`,
        // add the new element "one and a half" using `listIterator.add()`,
        // and then move the iterator forward again using `listIterator.next()`.
        // This effectively inserts the new element before the string "two".

        //---

        //so I can modify a list via ListIterator?

        //Yes, you can modify a list using `ListIterator` in Java. The `ListIterator` interface provides methods to insert,
        // replace, and remove elements while iterating through the list. Here's an example:
        //
        //```java
        //import java.util.ArrayList;
        //import java.util.List;
        //import java.util.ListIterator;
        //
        //public class Main {
        //    public static void main(String[] args) {
        //        List<String> list = new ArrayList<>();
        //        list.add("one");
        //        list.add("two");
        //        list.add("three");
        //
        //        ListIterator<String> listIterator = list.listIterator();
        //
        //        while (listIterator.hasNext()) {
        //            String element = listIterator.next();
        //
        //            // Replace the current element
        //            if (element.equals("two")) {
        //                listIterator.set("two and a half");
        //            }
        //
        //            // Insert an element before the current element
        //            if (element.equals("three")) {
        //                listIterator.add("two and three quarters");
        //            }
        //        }
        //
        //        System.out.println(list);  // Output: [one, two and a half, two and three quarters, three]
        //    }
        //}
        //```
        //
        //In this code, we're using a `ListIterator` to iterate over a list of strings.
        // When we encounter the string "two", we replace it with "two and a half" using `listIterator.set()`.
        // When we encounter the string "three", we insert "two and three quarters" before it using `listIterator.add()`.

        //---

        //what to prefer - how to modify a list - via the list methods or via the listiterator methods?

        //Both methods of modifying a list in Java - using `List` methods or `ListIterator` methods - have their own use cases
        // and it depends on the specific requirements of your code.
        //
        //1. **Using List methods**:
        // If you are performing simple operations like adding an element at the end of the list,
        // removing an element by its value or index, or updating an element at a specific index,
        // using `List` methods is straightforward and convenient.
        //
        //```java
        //List<String> list = new ArrayList<>();
        //list.add("one");  // Add element
        //list.remove("one");  // Remove element by value
        //list.remove(0);  // Remove element by index
        //list.set(0, "two");  // Update element
        //```
        //
        //2. **Using ListIterator methods**:
        // If you need to modify the list while iterating over it, `ListIterator` is the preferred choice.
        // It allows you to add, remove, and set elements while iterating,
        // which is not possible with a simple for-each loop using `List` methods
        // because it can result in a `ConcurrentModificationException`.
        //
        //```java
        //ListIterator<String> listIterator = list.listIterator();
        //while (listIterator.hasNext()) {
        //    String element = listIterator.next();
        //    if (element.equals("two")) {
        //        listIterator.set("three");  // Update element
        //        listIterator.add("two and a half");  // Add element
        //    }
        //}
        //```
        //
        //In summary, if you're not modifying the list while iterating,
        // `List` methods are usually simpler and more straightforward.
        // If you are modifying the list during iteration,
        // `ListIterator` provides the necessary functionality to do so safely.

        //---
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //If I override an iterator() for a list and use the for-each - which iterrator will be used from the for-each loop -
        // the natural order one or the overiden one?

        //When you use a for-each loop on an object of a class that implements `Iterable`,
        // the `iterator()` method of that class is called.
        // If you have overridden the `iterator()` method in your class, then your overridden method will be used.
        //
        //This means that the for-each loop will use the iterator as defined by your overridden `iterator()` method,
        // not the natural order one.
        // This allows you to control the order in which elements are iterated over in a for-each loop
        // by defining your own `iterator()` method.


    }
}
