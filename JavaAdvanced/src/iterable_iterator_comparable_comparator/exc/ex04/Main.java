package iterable_iterator_comparable_comparator.exc.ex04;

public class Main {
    public static void main(String[] args) {
        Lake lake = new Lake(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (Integer position : lake) {
            System.out.print(position + " ");
        }
    }

    /**
     * In this code, lake is an instance of the Lake class, which implements Iterable<Integer>.
     * When you use a for-each loop (for (Integer position : lake)),
     * it automatically calls the iterator() method on the lake object.
     * This method returns an instance of the Frog class,
     * which implements Iterator<Integer>.
     * The for-each loop then uses this iterator to iterate over the positions in the lake.
     */
}
