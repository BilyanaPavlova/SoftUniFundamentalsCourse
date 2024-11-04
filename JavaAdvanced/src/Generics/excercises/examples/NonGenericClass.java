package Generics.excercises.examples;

public class NonGenericClass {

    public static <T extends Comparable<T>> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
