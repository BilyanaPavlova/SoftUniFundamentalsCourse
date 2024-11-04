package Generics.lecture.arrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Create a class ArrayCreator with a method and a single overload to it:
 * •	static T[] create(int length, T item)
 * •	static T[] create(Class<T> class, int length, T item)
 * The method should return an array with the given length, and every element should be set to the given default item.
 */

public class ArrayCreator {

    /**
     * The array is created by casting a new `Object` array to `T[]`.
     *  * This is a simple way to create a generic array, but it can lead to `ArrayStoreException` at runtime
     *  * if you try to store an object that is not of type `T` in the array.
     */

    public static <T> T[] create(int length, T item){
        T[] items = (T[]) new Object[length];//кастваме без да сме сигурни обекта от какъв тип ще е, затова е жулто. Работим с Обект масив
        for (int i = 0; i < length; i++) {
            items[i] = item;
        }
        return items;
    }

    /**
     *  * The array is created using `Array.newInstance()`, which creates a new array with the specified component type and length.
     *  * This method is safer because it ensures that the array is of the correct type at runtime.
     */

    public static <T> T[] create (Class<T> clazz, int length, T item){

        T[] items = (T[]) Array.newInstance(clazz, length);// Работим с  масив от типа Т - в зависимост какъв Т е подаден ат рънтайм

        for (int i = 0; i < items.length; i++) {
            items[i] = item;
        }
        return items;

    }

    /**
     * The difference between the two methods lies in the type safety of the array creation.
     *
     * The first method `create(int length, T item)` creates an array of `Object` and then casts it to `T[]`. This can lead to `ArrayStoreException` at runtime if you try to store an object that is not of type `T` in the array.
     *
     * The second method `create(Class<T> clazz, int length, T item)` uses `Array.newInstance()`, which creates a new array with the specified component type and length. This method is safer because it ensures that the array is of the correct type at runtime.
     *
     * Here are examples of how you might call these methods:
     *
     * ```java
     * // Using the first method
     * String[] stringArray1 = ArrayCreator.create(5, "Hello");
     * // This will create an array of Strings of length 5, all initialized to "Hello"
     *
     * // Using the second method
     * String[] stringArray2 = ArrayCreator.create(String.class, 5, "Hello");
     * // This will also create an array of Strings of length 5, all initialized to "Hello"
     * ```
     *
     * In both cases, you get an array of Strings of length 5, all initialized to "Hello". However, the second method is safer because it ensures that the array is of the correct type at runtime. If you try to store an object that is not a String in `stringArray1`, you will get an `ArrayStoreException` at runtime. But with `stringArray2`, you would get a compile-time error, which is easier to catch and fix.
     *
     * Here's an example of how you might try to store an object that is not a String in the array created by the first method:
     *
     * ```java
     * // Using the first method
     * Object[] objectArray = ArrayCreator.create(5, "Hello");
     * // This will create an array of Objects of length 5, all initialized to "Hello"
     *
     * // Now, let's try to store an Integer in this array
     * objectArray[0] = 1; // This will throw an ArrayStoreException at runtime
     * ```
     *
     * In this example, we first create an array of Objects with the `create` method. Then, we try to store an Integer in this array. This will throw an `ArrayStoreException` at runtime because the array is actually an array of Strings, not Objects, and an Integer is not a String.
     */

}
