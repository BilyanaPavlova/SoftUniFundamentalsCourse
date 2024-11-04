package Generics.lecture.scale;

/**
 *Create a class Scale<T> that holds two elements - left and right. The scale should receive the elements through its single constructor:
 * •	Scale(T left, T right)
 * The scale should have a single method:
 * •	T getHeavier()
 * The greater of the two elements is heavier. The method should return null if elements are equal.
 */

public class Scale <T extends Comparable<T>>{
    T left;
    T right;

    public Scale (T left, T right){
        this.left = left;
        this.right = right;
    }

    public T getHeavier (){

            if(left.compareTo(right) == 0){
                return null;
            }
            if(left.compareTo(right) < 0){
                return right;
            }
            return left;
        }
    }
