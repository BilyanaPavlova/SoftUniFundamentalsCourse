package iterable_iterator_comparable_comparator.exc.USE_CUSTOM_ITEARTOR;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// това, което можем да итерираме имплементира Iterable, за да можем да го итерираме
// нещото, с което итерираме е Itearator, който имплементира hasNext() и next()
// итератора е вътрешен клас на класа, който итерираме и имплементира Iterator
// итераторът се връша от метода iterator() на класа, който итерираме, и който трябва да е Iterable

public class MyList <T> implements Iterable<T> {

    private List<T> collection;

    public MyList(T ... names) {
        this.collection = Arrays.asList(names);
    }

    public MyList(List<T> list){
        this.collection = list;
    }

    //override iterator() method -> must make MyList iterable
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    //inner class MyListIterator
    public class MyListIterator implements Iterator<T> {

        private int currentIdx = 0;

        @Override
        public boolean hasNext() {
            return currentIdx < collection.size();
        }

        // 1 2 3 4 5 6 7 8 9
        @Override
        public T next() {
            if(!hasNext()) {
                throw new UnsupportedOperationException("No more elements");
            }
            T element = collection.get(currentIdx);
            currentIdx += 2; // increment index by 2
            return element;
        }
    }

    //second iterator

    public Iterator<T> secondIterator() {
        return new MyListSecondIterator();
    }

    public class MyListSecondIterator implements Iterator<T> {

        int currentIdx = collection.size()-1;

        @Override
        public boolean hasNext() {
            return currentIdx >= 0;
        }

        @Override
        public T next() {

            if(!hasNext()){
                throw new UnsupportedOperationException("No more elements");
            }
            T element = collection.get(currentIdx);
            currentIdx -= 3;
            return element;
        }
    }
}
