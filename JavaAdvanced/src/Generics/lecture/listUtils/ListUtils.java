package Generics.lecture.listUtils;

import java.util.List;

/**
 * Create a class ListUtils that you will use through several other exercises:
 * The class should have two static methods:
 * •	T getMin(List<T> list)
 * •	T getMax(List<T> list)
 * The methods should throw IllegalArgumentException if an empty list is passed.
 */

public class ListUtils  {

    public static <T extends Comparable<T>> T getMax(List<T> list){

        T max = list.get(0);
        for (int i = 1; i < list.size() ; i++) {
            if(max.compareTo(list.get(i)) <= 0){
                max = list.get(i);
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T getMin(List<T> list){

        T min = list.get(0);
        for (int i = 1; i < list.size() ; i++) {
            if(min.compareTo(list.get(i)) >= 0){
                min = list.get(i);
            }
        }
        return min;
    }



}
