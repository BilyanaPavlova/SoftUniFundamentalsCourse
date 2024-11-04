//package iterable_iterator_comparable_comparator.lec;
//
//public class Notes_Varargs_Iterable_Iterator {
//
//    /**
//     * varargs - variable arguments
//     *
//     * In Java, variable arguments (varargs) allow you to pass an arbitrary number of arguments of the same type to a method.
//     * You can declare a method to accept varargs by following the type of the last parameter by an ellipsis (...), three dots.
//     *
//     * Here's an example of a method that accepts variable arguments:
//     *
//     * ```java
//     * public class VarArgsExample {
//     *     public static void main(String[] args) {
//     *         printNumbers(1, 2, 3, 4, 5);
//     *         printNumbers(10, 20, 30);
//     *     }
//     *
//     *     static void printNumbers(int... numbers) {
//     *         for (int number : numbers) {
//     *             System.out.println(number);
//     *         }
//     *     }
//     * }
//     * ```
//     *
//     * In this example, the `printNumbers` method is declared with a varargs parameter of type `int`.
//     * This means you can call `printNumbers` with any number of `int` arguments.
//     * The varargs parameter is treated as an array inside the method.!!!!!!
//     *
//     * Arrays.asList(array) - returns mutable list!!!
//     * List.of(1, 2, 3) -> returns immutable list!!!!
//     *
//     */
//
//    /**
//     * всички колекции са iterable
//     *
//     * iterable = can be iterated. Интерфейсът казва: "аз мога" - да обходя някакви данни в случая
//     * iterator - how to be iterated. Each collection has it;s own iterator. Итераторът е нещото, което го прави - обхожда
//     * Итераторът е методът, който е на интерфейса и всеки клас, който имплементира интерфейса, е длъжен да имплементира методът Итератор по свой начин.
//     *
//     * Iteratot<T> iterator();
//     *
//     * Iterable -> да можеме да заг=дължим един клас да имплементира Iterable метода както си иска, но да го имплементира
//     *
//     * Всеки един тип, който имплементира Итератор, може да бъде използван във foreach!!! Правилото е това!!!!!!
//     * Тип , който не имплементира Итерабле, не може да бъде използван във foreach!!!!!!
//     *
//     * Itertor - друг интерфейс , който знае как да обходи напите данни
//     * има два метода:
//     * boolean hasnwxt - докато има следваш елемент
//     * и next - връша елемента
//     */
//
//    /**
//     *
//     * Example and explanation:
//     *
//     * In Java, `Iterable` and `Iterator` are two interfaces that provide the ability to iterate over a collection of elements.
//     *
//     * `Iterable` is an interface that represents a collection of elements that can be iterated over.
//     * It has one abstract method, `iterator()`, which returns an `Iterator`.
//     *
//     * `Iterator` is an interface that provides methods to iterate over any `Iterable`. It has three methods:
//     *
//     * - `hasNext()`: Returns `true` if there are more elements to iterate.
//     * - `next()`: Returns the next element in the iteration.
//     * - `remove()`: Removes the last element returned by the iterator.
//     *
//     * Here's an example of how to use `Iterable` and `Iterator`:
//     *
//     * ```java
//     * import java.util.*;
//     *
//     * public class Main {
//     *     public static void main(String[] args) {
//     *         List<String> names = new ArrayList<>();
//     *         names.add("Alice");
//     *         names.add("Bob");
//     *         names.add("Charlie");
//     *
//     *         // Get an iterator
//     *         Iterator<String> iterator = names.iterator();
//     *
//     *         // Use the iterator
//     *         while (iterator.hasNext()) {
//     *             String name = iterator.next();
//     *             System.out.println(name);
//     *         }
//     *
//     *         // Use for-each loop (which uses the Iterable interface implicitly)
//     *         for (String name : names) {
//     *             System.out.println(name);
//     *         }
//     *     }
//     * }
//     * ```
//     *
//     * In this example, we first create a list of names. We then get an iterator from the list and use it to print each name.
//     * Finally, we use a for-each loop to print each name, which implicitly uses the `Iterable` interface.
//     *
//     * It's important to note that the `Iterable` interface is the root interface for all the collection classes except `Map`.
//     * That's why you can use a for-each loop with any collection class.
//     */
//
//    /**
//     * how can we use a for each loop with a custom class
//     *
//     * To use a for-each loop with a custom class in Java, your class needs to implement the `Iterable` interface.
//     * This interface requires you to implement a method called `iterator()`, which returns an `Iterator` for your class.
//     *
//     * Here's an example of a custom class `CustomList` that implements `Iterable`:
//     *
//     * ```java
//     * import java.util.Iterator;
//     * import java.util.NoSuchElementException;
//     *
//     * public class CustomList implements Iterable<Integer> {
//     *     private Integer[] items;
//     *
//     *     public CustomList(Integer[] items) {
//     *         this.items = items;
//     *     }
//     *
//     *     @Override
//     *     public Iterator<Integer> iterator() {
//     *         return new Iterator<Integer>() {
//     *             private int currentIndex = 0;
//     *
//     *             @Override
//     *             public boolean hasNext() {
//     *                 return currentIndex < items.length;
//     *             }
//     *
//     *             @Override
//     *             public Integer next() {
//     *                 if (!hasNext()) {
//     *                     throw new NoSuchElementException();
//     *                 }
//     *                 return items[currentIndex++];
//     *             }
//     *         };
//     *     }
//     * }
//     * ```
//     *
//     * In this example, `CustomList` is a simple wrapper around an array of `Integer`.
//     * It implements `Iterable<Integer>`, meaning it can be used with a for-each loop.
//     * The `iterator()` method returns an anonymous class that implements `Iterator<Integer>`.
//     * This iterator goes through each element in the `items` array one by one.
//     *
//     * Now you can use a for-each loop with `CustomList`:
//     *
//     * ```java
//     * public class Main {
//     *     public static void main(String[] args) {
//     *         CustomList customList = new CustomList(new Integer[]{1, 2, 3, 4, 5});
//     *
//     *         for (Integer item : customList) {
//     *             System.out.println(item);
//     *         }
//     *     }
//     * }
//     * ```
//     *
//     * This will print out each item in the `CustomList`.
//     *
//     */
//
//    /**
//     * why the Iterable does not have directly the methods hasNext, next and remove?
//     * why it is necessary these methods to be in a separate Interface that is returned by Iterable?
//     *
//     * The `Iterable` interface and the `Iterator` interface in Java have distinct responsibilities.
//     *
//     * The `Iterable` interface is used for objects that can provide an iterator,
//     * which means they have a collection of elements that can be iterated over.
//     * The `Iterable` interface has a single method, `iterator()`, which returns an `Iterator` object.
//     *
//     * The `Iterator` interface, on the other hand,
//     * is used for objects that can iterate over a collection of elements.
//     * It provides the methods `hasNext()`, `next()`, and `remove()` to facilitate this iteration.
//     *
//     * Separating these responsibilities into two interfaces provides flexibility
//     * and follows the Single Responsibility Principle of software design.
//     * This way, a class can implement `Iterable` to indicate that it can provide an iterator,
//     * but the actual details of how the iteration is performed are encapsulated within the `Iterator` object.
//     * !!!!!!!!!
//     * This allows for different kinds of iterators to be used with the same iterable object, if desired.
//     *
//     *
//     * For example, a collection class could provide different iterators that traverse its elements in different orders.
//     * If the iteration methods were part of the `Iterable` interface itself,
//     * this kind of flexibility would not be possible.
//     *
//     * example of different iterators:
//     * give me example for this: a collection class could provide different iterators that traverse its elements in different orders.
//     *
//     * Sure, let's consider a simple `CustomList` class that can return two types of iterators:
//     * one that iterates in the normal order (from first to last),
//     * and another one that iterates in reverse order (from last to first).
//     *
//     * Here's how you could implement this in Java:
//     *
//     * ```java
//     * import java.util.Iterator;
//     * import java.util.NoSuchElementException;
//     *
//     * public class CustomList implements Iterable<Integer> {
//     *     private Integer[] items;
//     *
//     *     public CustomList(Integer[] items) {
//     *         this.items = items;
//     *     }
//     *
//     *     @Override
//     *     public Iterator<Integer> iterator() {
//     *         return new Iterator<Integer>() {
//     *             private int currentIndex = 0;
//     *
//     *             @Override
//     *             public boolean hasNext() {
//     *                 return currentIndex < items.length;
//     *             }
//     *
//     *             @Override
//     *             public Integer next() {
//     *                 if (!hasNext()) {
//     *                     throw new NoSuchElementException();
//     *                 }
//     *                 return items[currentIndex++];
//     *             }
//     *         };
//     *     }
//     *
//     *     public Iterator<Integer> reverseIterator() {
//     *         return new Iterator<Integer>() {
//     *             private int currentIndex = items.length - 1;
//     *
//     *             @Override
//     *             public boolean hasNext() {
//     *                 return currentIndex >= 0;
//     *             }
//     *
//     *             @Override
//     *             public Integer next() {
//     *                 if (!hasNext()) {
//     *                     throw new NoSuchElementException();
//     *                 }
//     *                 return items[currentIndex--];
//     *             }
//     *         };
//     *     }
//     * }
//     * ```
//     *
//     * In this example, the `iterator()` method returns an iterator that goes through the elements in the normal order,
//     * while the `reverseIterator()` method returns an iterator that goes through the elements in reverse order.
//     *
//     * Here's how you could use these iterators:
//     *
//     * ```java
//     * public class Main {
//     *     public static void main(String[] args) {
//     *         CustomList customList = new CustomList(new Integer[]{1, 2, 3, 4, 5});
//     *
//     *         System.out.println("Normal order:");
//     *         for (Integer item : customList) {
//     *             System.out.println(item);
//     *         }
//     *
//     *         System.out.println("Reverse order:");
//     *         Iterator<Integer> reverseIterator = customList.reverseIterator();
//     *         while (reverseIterator.hasNext()) {
//     *             System.out.println(reverseIterator.next());
//     *         }
//     *     }
//     * }
//     * ```
//     *
//     * This will print out the items in the `CustomList` first in normal order, then in reverse order.
//     *
//     * why  these two differ in the calling ?  System.out.println("Normal order:");
//     *         for (Integer item : customList) {
//     *             System.out.println(item);
//     *         }
//     *
//     *         System.out.println("Reverse order:");
//     *         Iterator<Integer> reverseIterator = customList.reverseIterator();
//     *         while (reverseIterator.hasNext()) {
//     *             System.out.println(reverseIterator.next());
//     *         }
//     *
//     * The difference in the calling of these two blocks of code
//     * is due to the way the Java `for-each` loop and the `Iterator` work.
//     *
//     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//     * The `for-each` loop in Java is a simplified syntax for iterating over collections
//     * that implement the `Iterable` interface.
//     * Under the hood, it automatically calls the `iterator()` method on the collection
//     * and uses the returned `Iterator` to loop over the elements.
//     * This is why you can directly use `for (Integer item : customList)` without manually creating an `Iterator`.
//     *
//     * On the other hand, the `reverseIterator()` method is a custom method that returns an `Iterator`
//     * which iterates over the elements in reverse order.
//     * The `for-each` loop cannot be used with this `Iterator`
//     * because the `for-each` loop implicitly calls the `iterator()` method, not the `reverseIterator()` method.
//     * Therefore, you need to manually create the `Iterator` and use a `while` loop to iterate over the elements.
//     */
//
//    /** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//     * what is the difference between foreach and iterator methods of the iterable? does not they do the same?
//     *
//     * The `forEach` and `iterator` methods of the `Iterable` interface in Java both provide ways to iterate over a collection,
//     * but they are used in different ways and have different purposes.
//     *
//     * 1. `iterator()`: This method returns an `Iterator` object, which can be used to iterate over the collection.
//     * The `Iterator` provides methods like `hasNext()` and `next()` to manually control the iteration process.
//     * This is useful when you need more control over the iteration,
//     * such as removing elements during iteration or iterating over a collection in a custom way.
//     *
//     * ```java
//     * Iterator<Book> iterator = library.iterator();
//     * while (iterator.hasNext()) {
//     *     Book book = iterator.next();
//     *     System.out.println(book.getTitle());
//     * }
//     * ```
//     *
//     * 2. `forEach()`: This method is a default method of the `Iterable` interface introduced in Java 8.
//     * It takes a `Consumer` functional interface as an argument and applies it to each element in the collection.
//     * This is a more declarative approach and is useful
//     * when you want to perform an action on each element of the collection
//     * and don't need to control the iteration process manually.
//     *
//     * ```java
//     * library.forEach(book -> System.out.println(book.getTitle()));
//     * ```
//     *
//     * In summary, while both methods are used for iteration,
//     * `iterator()` provides a way to manually control the iteration process,
//     * while `forEach()` provides a way to perform an action on each element in a more declarative way.
//     *
//     */
//
//    /**
//     * Consumer with functional programming?
//     *
//     * Yes, the `Consumer` interface is a part of Java's functional programming model.
//     * It represents an operation that accepts a single input argument and returns no result.
//     * This is a functional interface and can therefore be used as the assignment target for a lambda expression
//     * or method reference.
//     *
//     * Here's an example of using `Consumer` with a lambda expression:
//     *
//     * ```java
//     * import java.util.Arrays;
//     * import java.util.List;
//     * import java.util.function.Consumer;
//     *
//     * public class Main {
//     *     public static void main(String[] args) {
//     *         List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//     *
//     *         Consumer<String> printConsumer = name -> System.out.println(name);
//     *
//     *         names.forEach(printConsumer);
//     *     }
//     * }
//     * ```
//     *
//     * In this example, `printConsumer` is a `Consumer` that takes a `String` and prints it.
//     * The lambda expression `name -> System.out.println(name)` is a concise way to define this behavior.
//     * The `forEach` method is then used to apply this `Consumer` to each element in the `names` list.
//     *
//     * This is an example of functional programming because it involves using functions
//     * (or in this case, lambda expressions) as first-class values that can be passed around and operated on.
//     */
//
//    /**
//     *  how's that I can iterate through the books with a for-each loop, when the Book has not implemented iterable
//     *
//     *  The `for-each` loop in Java can be used with any object that implements the `Iterable` interface,
//     *  but it can also be used with any array.
//     *  In your case, you're using the `for-each` loop to iterate over a `List<Book>`, not a `Book`.
//     *
//     * The `List` interface extends `Collection`, which in turn extends `Iterable`.
//     * Therefore, all lists in Java are inherently iterable,
//     * and you can use the `for-each` loop to iterate over any list.
//     *
//     * Here's the relevant part of your code:
//     *
//     * ```java
//     * List<Book> books = new ArrayList<>();
//     * books.add(bookOne);
//     * books.add(bookTwo);
//     * books.add(bookThree);
//     *
//     * for(Book book: books){
//     *     System.out.println(book);
//     * }
//     * ```
//     *
//     * In this code, `books` is a list of `Book` objects.
//     * When you use `for(Book book: books)`, you're iterating over the `books` list, not a `Book`.
//     * Each iteration of the loop gives you one `Book` object from the list, which you're calling `book`.
//     *
//     * So, to clarify, you're not using a `for-each` loop to iterate over a `Book`;
//     * you're using it to iterate over a `List<Book>`.
//     * The `Book` class doesn't need to implement `Iterable` because you're not trying to iterate over a `Book`.
//     */
//
//    /**
//     * why Iterator can return an object Iterator? is not it an interface?
//     *
//     * Yes, `Iterator` is an interface in Java. When a method returns an `Iterator`,
//     * it's actually returning an instance of some class that implements the `Iterator` interface.
//     *
//     * In Java, an interface is a reference type, similar to a class, that can contain only constants,
//     * method signatures, default methods, static methods, and nested types.
//     * It provides a way to ensure that a class adheres to a certain contract without having to inherit from a class.
//     *
//     * When we say a method returns an `Iterator`, we mean it returns an object of a class
//     * that implements the `Iterator` interface.
//     * This object has the methods defined in the `Iterator` interface (`hasNext()`, `next()`, and optionally `remove()`).
//     *
//     * Here's an example:
//     *
//     * ```java
//     * public class MyCollection implements Iterable<String> {
//     *     // ...
//     *
//     *     @Override
//     *     public Iterator<String> iterator() {
//     *         return new Iterator<String>() {
//     *             // ...
//     *
//     *             @Override
//     *             public boolean hasNext() {
//     *                 // Implementation of hasNext
//     *             }
//     *
//     *             @Override
//     *             public String next() {
//     *                 // Implementation of next
//     *             }
//     *         };
//     *     }
//     * }
//     * ```
//     *
//     * In this example, the `iterator()` method returns an instance of an anonymous class that implements the `Iterator` interface.
//     * This instance has its own implementations of the `hasNext()` and `next()` methods.
//     */
//
//    /**
//     * I knew that interfaces can be only implemented, but can not be instantiated?
//     * how's that the iterator method returns an Iterator?
//     *
//     * !!!!!!!!!!!!!!!!!
//     * Yes, you're correct that interfaces in Java cannot be instantiated directly.
//     * However, they can be implemented by classes.
//     * When a method returns an interface, it's actually returning an instance of some class
//     * that implements that interface.
//     *
//     * In the case of the `iterator()` method, it's returning an instance of an anonymous inner class
//     * that implements the `Iterator` interface.
//     * An anonymous inner class is a class without a name that is declared and instantiated in a single statement.
//     *
//     * Here's an example from your `Library` class:
//     *
//     * ```java
//     * @Override
//     * public Iterator<Book> iterator() {
//     *     return new Iterator<Book>() {
//     *
//     *         private int currentIdx = 0;
//     *
//     *         @Override
//     *         public boolean hasNext() {
//     *             return currentIdx <= Library.this.books.size()-1;
//     *         }
//     *
//     *         @Override
//     *         public Book next() {
//     *             if(!hasNext()){
//     *                 throw new NoSuchElementException();
//     *             } else {
//     *                 return Library.this.books.get(currentIdx++);
//     *             }
//     *         }
//     *     };
//     * }
//     * ```
//     *
//     * In this code, `new Iterator<Book>() {...}` is creating a new instance of an anonymous inner class
//     * that implements the `Iterator` interface.
//     * This instance has its own implementations of the `hasNext()` and `next()` methods. The `iterator()` method
//     * then returns this instance.
//     *
//     * why then do we not write return new Iterator<Book> implements Iterator?
//     *
//     * In Java, the `new` keyword is used to create an instance of a class. When you see `new Iterator<Book>() {...}`, it's creating an instance of an anonymous class that implements the `Iterator<Book>` interface.
//     *
//     * The `implements` keyword is used in the class declaration to indicate that a class is intended to implement an interface, like so:
//     *
//     * ```java
//     * public class MyClass implements MyInterface {
//     *     // class body
//     * }
//     * ```
//     *
//     * However, in the case of an anonymous class, the `implements` keyword is not used. Instead, the interface is specified after the `new` keyword, and the class body is provided inline. Here's the general syntax:
//     *
//     * ```java
//     * new InterfaceName() {
//     *     // methods that implement the interface
//     * }
//     * ```
//     *
//     * So, when you see `new Iterator<Book>() {...}`, it's shorthand for "create a new instance of a class (which we're not going to name) that implements the `Iterator<Book>` interface, and here are the method implementations".
//     */
//
//    /**
//     * !!!!!!!!!!!!!!!!!!
//     * cannt we implement Iterator interface with an nested class?
//     *
//     * Yes, you can certainly use a nested class instead of an anonymous class to implement the `Iterator` interface.
//     * A nested class is a class defined within another class.
//     * Here's how you could modify the `Library` class to use a nested class:
//     *
//     * ```java
//     * package iterator.lec.ex02;
//     *
//     * import iterator.lec.ex01.Book;
//     *
//     * import java.util.Arrays;
//     * import java.util.Iterator;
//     * import java.util.List;
//     * import java.util.NoSuchElementException;
//     *
//     * public class Library implements Iterable<Book> {
//     *
//     *     List<Book> books;
//     *
//     *     public Library(Book... books) { //varargs is an array
//     *         this.books = Arrays.asList(books); //converts the array to list
//     *     }
//     *
//     *     @Override
//     *     public Iterator<Book> iterator() {
//     *         return new BookIterator(); // the method iterator will return an instance of a class
//     *     }
//     *
//     *     private class BookIterator implements Iterator<Book> {  // this is the class
//     *
//     *         private int currentIdx = 0;
//     *
//     *         @Override
//     *         public boolean hasNext() {
//     *             return currentIdx <= Library.this.books.size()-1;
//     *         }
//     *
//     *         @Override
//     *         public Book next() {
//     *             if(!hasNext()){
//     *                 throw new NoSuchElementException();
//     *             } else {
//     *                 return Library.this.books.get(currentIdx++);
//     *             }
//     *         }
//     *     }
//     * }
//     * ```
//     *
//     * In this code, `BookIterator` is a nested class that implements the `Iterator` interface. T
//     * he `iterator()` method returns an instance of this nested class. T
//     * he nested class has access to all the fields and methods of its enclosing class,
//     * so it can directly access the `books` list and the `currentIdx` field.
//     *
//     * how can I call this?
//     *
//     * Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
//     * Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
//     * Book bookThree = new Book("The Documents in the Case", 2002);
//     *
//     * Library library = new Library(bookOne, bookTwo, bookThree);
//     *
//     * Iterator<Book> bookIterator = library.iterator(); //returns instance of the class boobkitearror
//     *
//     * while (bookIterator.hasNext()) {
//     *     Book book = bookIterator.next();
//     *     System.out.println(book.getTitle());
//     * }
//     */
////-----------------
//    /**
//     * what is better - anonymous class or nested class?
//     *
//     * The choice between using an anonymous class or a nested class in Java depends on the specific requirements of your code. Here are some factors to consider:
//     *
//     * 1. **Code Reusability**: If the class is used in multiple places, a nested class is a better choice because it can be reused, while an anonymous class cannot.
//     *
//     * 2. **Code Readability**: Anonymous classes can make the code difficult to read if they are very large or complex. In such cases, a nested class might be a better choice.
//     *
//     * 3. **Simplicity**: If the class is small and used only once (typically in the place where it is defined), an anonymous class can make the code more concise.
//     *
//     * 4. **Access to Local Variables**: Anonymous classes have access to final or effectively final local variables of the enclosing scope, while nested classes do not.
//     *
//     * In summary, if the class is small, used only once, and benefits from access to local variables, an anonymous class might be the better choice. For larger, more complex classes that are used in multiple places, a nested class would be more appropriate.
//     *
//     */
//
//    /**
//     * Give me example of these both: Code Reusability: If the class is used in multiple places, a nested class is a better choice because it can be reused, while an anonymous class cannot.
//     *
//     * Sure, let's consider a scenario where we have a `Library` class that contains `Book` objects. We want to iterate over the books in two different ways: in the normal order (from first to last), and in reverse order (from last to first).
//     *
//     * For this, we can create two nested classes, `BookIterator` and `ReverseBookIterator`, that implement the `Iterator` interface. These classes can be reused in multiple places in our code.
//     *
//     * Here's how you could implement this in Java:
//     *
//     * ```java
//     * import java.util.Arrays;
//     * import java.util.Iterator;
//     * import java.util.List;
//     * import java.util.NoSuchElementException;
//     *
//     * public class Library implements Iterable<Book> {
//     *
//     *     List<Book> books;
//     *
//     *     public Library(Book... books) {
//     *         this.books = Arrays.asList(books);
//     *     }
//     *
//     *     @Override
//     *     public Iterator<Book> iterator() {
//     *         return new BookIterator();
//     *     }
//     *
//     *     public Iterator<Book> reverseIterator() {
//     *         return new ReverseBookIterator();
//     *     }
//     *
//     *     private class BookIterator implements Iterator<Book> {
//     *
//     *         private int currentIdx = 0;
//     *
//     *         @Override
//     *         public boolean hasNext() {
//     *             return currentIdx < Library.this.books.size();
//     *         }
//     *
//     *         @Override
//     *         public Book next() {
//     *             if(!hasNext()){
//     *                 throw new NoSuchElementException();
//     *             } else {
//     *                 return Library.this.books.get(currentIdx++);
//     *             }
//     *         }
//     *     }
//     *
//     *     private class ReverseBookIterator implements Iterator<Book> {
//     *
//     *         private int currentIdx = Library.this.books.size() - 1;
//     *
//     *         @Override
//     *         public boolean hasNext() {
//     *             return currentIdx >= 0;
//     *         }
//     *
//     *         @Override
//     *         public Book next() {
//     *             if(!hasNext()){
//     *                 throw new NoSuchElementException();
//     *             } else {
//     *                 return Library.this.books.get(currentIdx--);
//     *             }
//     *         }
//     *     }
//     * }
//     * ```
//     *
//     * In this code, `BookIterator` and `ReverseBookIterator` are nested classes that implement the `Iterator` interface. The `iterator()` method returns an instance of `BookIterator`, and the `reverseIterator()` method returns an instance of `ReverseBookIterator`. These nested classes can be reused in multiple places in our code, unlike anonymous classes.
//     *
//     */
//    /**
//     * but anonymous classes will be used via the method iterator - is not that the same?
//     *
//     * Yes, you're correct. Both anonymous classes and nested classes can be used via the `iterator()` method. The difference lies in how they are defined and used.
//     *
//     * An anonymous class is defined and instantiated at the same place, typically inside a method like `iterator()`. It doesn't have a name, so it can't be reused elsewhere in your code. This is why it's often used for one-off needs where only a single instance of the class is required.
//     *
//     * On the other hand, a nested class is defined inside another class but outside any method. It has a name and can be instantiated multiple times in different methods, so it can be reused.
//     *
//     * So, while both anonymous and nested classes can be returned by the `iterator()` method, the choice between them depends on your specific needs in terms of code reusability, readability, and simplicity.
//     *
//     */
//    /**
//     * give me example of how the anonymous class can not be used on many places
//     *
//     * Sure, let's consider a scenario where you have a `Library` class that contains `Book` objects. You want to iterate over the books in a specific order, let's say, based on the year of publication.
//     *
//     * For this, you can create an anonymous class inside the `iterator()` method that implements the `Iterator` interface. However, this anonymous class can only be used inside this method and cannot be reused elsewhere in your code.
//     *
//     * Here's how you could implement this in Java:
//     *
//     * ```java
//     * import java.util.Arrays;
//     * import java.util.Iterator;
//     * import java.util.List;
//     * import java.util.NoSuchElementException;
//     *
//     * public class Library implements Iterable<Book> {
//     *
//     *     List<Book> books;
//     *
//     *     public Library(Book... books) {
//     *         this.books = Arrays.asList(books);
//     *     }
//     *
//     *     @Override
//     *     public Iterator<Book> iterator() {
//     *         return new Iterator<Book>() {
//     *             private int currentIdx = 0;
//     *
//     *             @Override
//     *             public boolean hasNext() {
//     *                 return currentIdx < Library.this.books.size();
//     *             }
//     *
//     *             @Override
//     *             public Book next() {
//     *                 if (!hasNext()) {
//     *                     throw new NoSuchElementException();
//     *                 }
//     *                 return Library.this.books.get(currentIdx++);
//     *             }
//     *         };
//     *     }
//     * }
//     * ```
//     *
//     * In this code, the `iterator()` method returns an anonymous class that implements the `Iterator` interface. This instance has its own implementations of the `hasNext()` and `next()` methods.
//     *
//     * Now, let's say you want to iterate over the books in reverse order in another part of your code. You cannot reuse the anonymous class you created earlier because it's defined inside the `iterator()` method. You would have to create another anonymous class that iterates in reverse order. This is one of the limitations of anonymous classes - they cannot be reused.
//     *
//     */
//    /**
//     * is not that the same with the nested classes - I have to create two different methods again in order to instantiate two different iterator
//     *  @Override
//     *     public Iterator<Book> iterator() {
//     *         return new BookIterator();
//     *     }
//     *
//     *     public Iterator<Book> reverseIterator() {
//     *         return new ReverseBookIterator();
//     *     }
//     *
//     *     Yes, you're correct. Both anonymous classes and nested classes can be used to create different iterators
//     *     for different purposes. In both cases, you would need to create separate methods for each iterator.
//     *
//     * The key difference is that a nested class has a name and can be reused in other parts of your code,
//     * while an anonymous class does not have a name and is defined and instantiated at the point of use.
//     * This makes nested classes more suitable for complex or reusable functionality,
//     * while anonymous classes are often used for one-off, simple tasks.
//     *
//     * In your example, `BookIterator` and `ReverseBookIterator` are nested classes that can be instantiated
//     * in the `iterator()` and `reverseIterator()` methods respectively.
//     * If you wanted to create another method that uses the same iteration logic,
//     * you could reuse these nested classes.
//     * With anonymous classes, you would have to define the class again.
//     */
//
//    /**
//     * когато ползваме Iterator за да итерираме, не променяме нишо по състоянието на класа, по който итерираме,
//     * !!!!!!!!!!!!!!!!!!!!!!!!! не сменяме текущия индекс примерно, както бихме го сменили с прости методи
//     */
//
//}
