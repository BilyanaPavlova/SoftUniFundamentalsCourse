package iterable_iterator_comparable_comparator.exc.USE_COMPARATOR.ex06;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int result = Integer.compare(p1.getName().length(), p2.getName().length());
        if (result == 0) {
            result = p1.getName().toLowerCase().charAt(0)  - p2.getName().toLowerCase().charAt(0);
        }
        return result;
    }
}
