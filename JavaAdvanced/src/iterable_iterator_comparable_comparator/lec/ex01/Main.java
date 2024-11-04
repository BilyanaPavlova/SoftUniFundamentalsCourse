package iterable_iterator_comparable_comparator.lec.ex01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        for(Book book: books){
            System.out.println(book);
        }
    }
}

/**
 * The for-each loop in Java can be used with any object that implements the Iterable interface,
 * but it can also be used with any array. In your case, you're using the for-each loop to iterate over a List<Book>,
 * not a Book.  The List interface extends Collection, which in turn extends Iterable.
 * Therefore, all lists in Java are inherently iterable, and you can use the for-each loop to iterate over any list.
 *
 * In this code, books is a list of Book objects. When you use for(Book book: books),
 * you're iterating over the books list, not a Book. Each iteration of the loop gives you one Book object from the list,
 * which you're calling book.
 * So, to clarify, you're not using a for-each loop to iterate over a Book; you're using it to iterate over a List<Book>.
 * The Book class doesn't need to implement Iterable because you're not trying to iterate over a Book.
 */
