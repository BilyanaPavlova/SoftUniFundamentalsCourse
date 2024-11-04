package iterable_iterator_comparable_comparator.exc.USE_CUSTOM_ITEARTOR;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for(Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // use the custom first custom iterator in a foreach loop of MyList
        MyList<Integer> myList = new MyList<>(nums);

        for(Integer num : myList) {
            System.out.print(num + " ");
        }

        System.out.println();

        // use the second custom iterator in a foreach loop of MyList
        Iterator<Integer> secondIterator = myList.secondIterator();
        while (secondIterator.hasNext()){
            System.out.print(secondIterator.next() + " ");
        }

        System.out.println();

        // use ListIterator object to manipulate a collection

        ListIterator<Integer> listIterator = nums.listIterator();

        listIterator.add(80);
        nums.forEach(e -> System.out.print(e + " "));
        listIterator.next();
        listIterator.set(90);
        nums.forEach(e -> System.out.print(e + " "));

        listIterator.previous();
        listIterator.remove();
        nums.forEach(e -> System.out.print(e + " "));




    }



}
//how to use the second iterator for MyList ? can I use it in a for-each loop again?

//In Java, the for-each loop uses the `Iterable` interface to iterate over collections.
// The `Iterable` interface has a single method, `iterator()`, which returns an `Iterator`.
// When you use a for-each loop on a collection, it automatically calls this `iterator()` method to get an `Iterator` object,
// and then uses this iterator to loop over the elements in a natural order.
//
//In your `MyList` class, you have two different iterators: `MyListIterator` and `MyListSecondIterator`.
// The `iterator()` method, which is overridden from the `Iterable` interface, returns a `MyListIterator`.
// This is why when you use a for-each loop on a `MyList` object, it uses the `MyListIterator`.
//
//The `secondIterator()` method returns a `MyListSecondIterator`, but this method is not part of the `Iterable` interface,
// because a method from an interface cannot be overridden twice in the same class in Java,
// so it's not used by the for-each loop.
//
//If you want to use the `MyListSecondIterator` in a for-each loop,
// you would need to create a new class that implements `Iterable` and uses `MyListSecondIterator` in its `iterator()` method.
// However, this would be a bit complicated and not very practical.
//
//A simpler solution would be to use a while loop to iterate over the elements using the `MyListSecondIterator`.
// Here's how you can do it:
//
//```java
//Iterator<Integer> secondIterator = myList.secondIterator();
//while(secondIterator.hasNext()) {
//    Integer num = secondIterator.next();
//    System.out.print(num + " ");
//}
//```
//
//In this code, we first get the `MyListSecondIterator` from the `myList` object
// by calling the `secondIterator()` method. Then we use a while loop to iterate over the elements.
// The `hasNext()` method of the iterator is used as the condition for the while loop, and the `next()` method
// is used to get each element.