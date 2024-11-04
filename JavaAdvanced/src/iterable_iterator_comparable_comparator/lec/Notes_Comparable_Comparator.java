package iterable_iterator_comparable_comparator.lec;

public class Notes_Comparable_Comparator {

    /**
     *give me example of how the anonymous class can not be used on many places
     *
     * `Comparable` and `Comparator` are both interfaces in Java that are used for sorting collections of objects. However, they are used in different scenarios and have different purposes.
     *
     * 1. `Comparable`:
     *    - This interface is used to define the natural order of objects of a certain class.
     *    - It is found in the `java.lang` package.
     *    - To use `Comparable`, a class must implement this interface and override the `compareTo(Object)` method.
     *    - The `compareTo(Object)` method returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     *    - It is used when you want to have only one sorting sequence.
     *    In other words, when you think that there is a single logical sorting sequence that makes sense for your class.
     *
     * Here is an example of how to use `Comparable`:
     *
     * ```java
     * public class Book implements Comparable<Book> {
     *     private String title;
     *
     *     // constructor, getters and setters
     *
     *     @Override
     *     public int compareTo(Book other) {
     *         return this.title.compareTo(other.title);
     *     }
     * }
     * ```
     *
     * 2. `Comparator`:
     *    - This interface is used to define custom orderings of objects of a certain class.
     *    - It is found in the `java.util` package.
     *    - To use `Comparator`, a class must implement this interface and override the `compare(Object, Object)` method.
     *    - The `compare(Object, Object)` method returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     *    - It is used when you want to sort a collection of objects in a way that is different from their natural ordering,
     *    or when you want to sort objects of a class that does not implement `Comparable`.
     *
     * Here is an example of how to use `Comparator`:
     *
     * ```java
     * import java.util.Comparator;
     *
     * public class BookTitleComparator implements Comparator<Book> {
     *     @Override
     *     public int compare(Book book1, Book book2) {
     *         return book1.getTitle().compareTo(book2.getTitle());
     *     }
     * }
     * ```
     *
     * In summary, if you have a class that has a natural ordering, use `Comparable`.
     * If you need to sort objects in different ways at different times, use `Comparator`.
     */

    /*
    `Comparable` and `Comparator` are both interfaces in Java used for defining the order of objects, often used in sorting. They serve different purposes:

1. `Comparable`: This interface is used to define the "natural" ordering of instances of a class. If a class implements `Comparable`, it's indicating that its instances have an intrinsic way of ordering themselves. For example, a `Book` class might implement `Comparable` to order books by their title. The `compareTo` method is used for this purpose. This is used in sorting methods like `Arrays.sort()` or `Collections.sort()` when no specific `Comparator` is provided.

2. `Comparator`: This interface is used to define an external class that knows how to compare two instances of another class. This is useful when you want to sort instances of a class in different ways at different times. For example, you might have a `BookTitleComparator` for sorting books by title, and a `BookAuthorComparator` for sorting books by author. The `compare` method is used for this purpose. This is used in sorting methods like `Arrays.sort()` or `Collections.sort()` when you want to provide a specific ordering.

So, while `Comparable` is used for a default, natural ordering, `Comparator` is used when you need different ways to sort instances of a class. They are not limited to sorting methods, but sorting is the most common use case. They can also be used with data structures that maintain a certain order, like `TreeSet` or `TreeMap`.

USE

Sure, let's consider a `Library` class that contains `Book` objects. Each `Book` has a `title` and a `yearOfPublication`. We can use `Comparable` to define a natural order for the books (for example, by title), and `Comparator` to define a custom order (for example, by year of publication).

Here's how you could implement this in Java:

First, let's define the `Book` class and make it implement `Comparable`:

```java
public class Book implements Comparable<Book> {
    private String title;
    private int yearOfPublication;

    // constructor, getters and setters

    public Book(String title, int yearOfPublication) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}
```

In this code, the `compareTo` method compares books by their titles. This will be the natural order for books.

Next, let's define a `Comparator` for comparing books by their year of publication:

```java
import java.util.Comparator;

public class BookYearComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book1.getYearOfPublication(), book2.getYearOfPublication());
    }
}
```

Finally, let's use these in the `Library` class:

```java
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(Book... books) {
        this.books = Arrays.asList(books);
    }

    public void sortBooksByTitle() {
        Collections.sort(books);
    }

    public void sortBooksByYearOfPublication() {
        Collections.sort(books, new BookYearComparator());
    }

    // other methods...
}
```

In the `Library` class, the `sortBooksByTitle` method sorts the books in their natural order (by title), and the `sortBooksByYearOfPublication` method sorts the books by their year of publication.

public class Book implements Comparable<Book> {
    private String title;
    private int yearOfPublication;

    // constructor, getters and setters

    public Book(String title, int yearOfPublication) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}

In this code, the compareTo method compares books by their titles. This will be the natural order for books.  Next, let's define a Comparator for comparing books by their year of publication:

Finally, let's use these in the Library class:
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(Book... books) {
        this.books = Arrays.asList(books);
    }

    public void sortBooksByTitle() {
        Collections.sort(books);
    }

    public void sortBooksByYearOfPublication() {
        Collections.sort(books, new BookYearComparator());
    }

    // other methods...
}

In the Library class, the sortBooksByTitle method sorts the books in their natural order (by title), and the sortBooksByYearOfPublication method sorts the books by their year of publication.
     */
}
