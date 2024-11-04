package iterable_iterator_comparable_comparator.exc.ex03;



import java.util.Iterator;
import java.util.Stack;

public class MyStack <T> implements Iterable<T>{

    Stack<T> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    public void push(T element) {
        this.stack.push(element);
    }

    public T pop() {
        if(this.stack.isEmpty()) {
            throw new IllegalStateException("No elements");
        }
        return this.stack.pop();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
            private int index = stack.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if(!hasNext())
                    throw new UnsupportedOperationException("No more elements");
                return stack.get(index--);
            }
    }






}
