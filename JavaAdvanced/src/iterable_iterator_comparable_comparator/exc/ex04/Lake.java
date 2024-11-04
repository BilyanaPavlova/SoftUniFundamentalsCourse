package iterable_iterator_comparable_comparator.exc.ex04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lake implements Iterable<Integer> {
    private Integer[] positions;

    public Lake(Integer... positions) {
        this.positions = positions;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private int index = 0;
        private boolean isEvenPhase = true;

        @Override
        public boolean hasNext() {
            if (isEvenPhase && index < positions.length) {
                return true;
            } else if (isEvenPhase) {
                isEvenPhase = false;
                index = 1;
            }
            return index < positions.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Integer position = positions[index];
            index += 2;
            return position;
        }
    }
}
