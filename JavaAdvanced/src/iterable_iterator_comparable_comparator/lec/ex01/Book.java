package iterable_iterator_comparable_comparator.lec.ex01;

import java.util.Arrays;
import java.util.List;

public class Book {

    private String title;
    private int year;
    private List<String> authors;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) { // зад varargs стои масив!!!!
        this.authors = Arrays.asList(authors); // затова ползваме това да го превърнем в лист, който е mutable List.of(authors) би го превърнало в иммутабле лист, но на нас ни трябва мутабле, защото ще даваме различен брой аргументи

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title = '" + title + '\'' +
                ", year = " + year +
                ", authors = " + authors +
                '}';
    }
}
