package Generics.excercises.ex03;

import java.util.List;

public class Utilities {


    public static <T extends Comparable<T>> Integer countGreater (List<T> list, T el) {
        int count = 0;
        for (T t : list) {
            if (el.compareTo(t) < 0 ){
                count++;
            }
        }
        return count;

    }


}
