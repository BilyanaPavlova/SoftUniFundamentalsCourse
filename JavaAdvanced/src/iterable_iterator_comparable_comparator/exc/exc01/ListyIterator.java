package iterable_iterator_comparable_comparator.exc.exc01;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T> {


    List<T> collection;
    private int currentIdx;

    public ListyIterator(T ... elements) {
        this.collection = Arrays.asList(elements);
        currentIdx = 0;
    }



    public boolean hasNext(){
        return currentIdx < collection.size() - 1;
    }

    public boolean move(){
        if(!hasNext()){
            return false;
        }

        currentIdx++;
        return true;
    }

    public void print(){

        // adding try-catch block, or throwing exception with a message, allows us to not throw the exception in the console, but to print the message
        try {
            System.out.println(this.collection.get(currentIdx));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Operation!");

        }

//        if (collection.isEmpty()) {
//            throw new IllegalArgumentException("Invalid Operation!");
//        }

    }

    public void printAll(){
        for (T t : collection) {
            System.out.print(t + " ");
        }
        System.out.println();
    }


    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0; // we do not change the state of the private currentIdx field above,
            // because we do not want to change the state of the object, when we iterate over the collection

            @Override
            public boolean hasNext() {
                return index < collection.size();
            }

            @Override
            public T next() {
                return collection.get(index++);
            }
        };
    }


}
