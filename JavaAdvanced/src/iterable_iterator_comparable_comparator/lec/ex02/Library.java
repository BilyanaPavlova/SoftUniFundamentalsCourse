package iterable_iterator_comparable_comparator.lec.ex02;

import iterable_iterator_comparable_comparator.lec.ex01.Book;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Library implements Iterable<Book> {

    List<Book> books;

    public Library(Book... books) {
        this.books = Arrays.asList(books);
    }


    @Override
    public Iterator<Book> iterator() {
        return new Iterator<Book>() {

            private int currentIdx = 0;

            @Override
            public boolean hasNext() {
                return currentIdx <= Library.this.books.size()-1;
            }

            @Override
            public Book next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                } else {
                    return Library.this.books.get(currentIdx++);
                }
            }
        };
    }
}

