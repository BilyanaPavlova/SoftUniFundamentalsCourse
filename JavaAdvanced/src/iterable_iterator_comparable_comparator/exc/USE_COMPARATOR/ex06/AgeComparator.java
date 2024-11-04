package iterable_iterator_comparable_comparator.exc.USE_COMPARATOR.ex06;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {

        int result = Integer.compare(o1.getAge(), o2.getAge());
        return result;
    }
}
