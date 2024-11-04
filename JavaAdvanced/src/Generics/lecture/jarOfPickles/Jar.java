package Generics.lecture.jarOfPickles;

import java.util.*;

/**
 * Create a class Jar<> that can store anything.
 * It should have two public methods:
 * •	void add(element)
 * •	element remove()
 * Adding should add on top of its contents. Remove should get the topmost element.
 */

public class Jar<T> {

    private Stack<T> things = new Stack<>();

    public void add(T el){
        this.things.add(el);

    }

    public T remove(){
        return this.things.pop();
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        for (T el: this.things) {
            strb.append(el).append(" ");
        }
        return strb.toString();
    }
}
