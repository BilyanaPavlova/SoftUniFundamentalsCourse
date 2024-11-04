package Generics.excercises.examples;


//can I have a static generic method in a generic class?????????

//Yes, you can have a static generic method in a generic class in Java. The static method's type parameter is independent of the type parameter of the class. Here's an example:
//In this example, GenericClass is a generic class with type parameter T, and printArray is a static generic method with its own type parameter U.
// This method can accept arrays of any type and print their elements.

public class GenericClass<T> {

    public static <U> void printArray(U[] array) {
        for (U element : array) {
            System.out.println(element);
        }
    }
}

//shoud the type parameters of the class and of the method be different always??????

//No, the type parameters of the class and the method do not always have to be different.
// It depends on the specific use case.  In a generic class, you can have a static generic method with the same type parameter as the class.
// !!!!!!However, it's important to note that static methods do not have access to the class-level type parameter!!!!!
// So, even if they have the same name, they are not the same type parameter.!!!!!

//In this example, the T in the method printArray is not the same T as in GenericClass<T>.
// They are two different type parameters that happen to have the same name.
// The T in printArray is a new type parameter that is only in scope for that method.
// If you want the static method to use the class's type parameter, you would need to make the method non-static!!!!!!!! As below:
//In this case, the T in printArray is the same T as in GenericClass<T>.
//public class GenericClass<T> {
//
//    public void printArray(T[] array) {
//        for (T element : array) {
//            System.out.println(element);
//        }
//    }
//}

//-----
//when I have to make a class generic

/**
 * You should make a class generic when:
 * You want the class to work with different data types while maintaining type safety.
 * This is often the case for data structures, where you want the structure to hold any type of data,
 * but you want to ensure that the data is of a consistent type within a specific instance of the structure.
 * For example, an ArrayList<T> can hold any type of data, but all elements within a specific ArrayList instance must be of the same type.
 * Multiple methods within the class need to operate on the same generic type. By making the class generic,
 * you can define the type parameter once for the entire class, rather than repeating it for each method.
 * Here's an example of a generic class:
 *
 * public class Box<T> {
 *     private T item;
 *
 *     public void setItem(T item) {
 *         this.item = item;
 *     }
 *
 *     public T getItem() {
 *         return item;
 *     }
 * }
 *
 *
 * can I make a class generic and the methods inside generic too. ANd can the class and the methods have the same type parameters
 * or they could have different type parameters?
 *
 * Yes, you can make a class generic and also have generic methods inside it.
 * The class and the methods can either have the same type parameters or different type parameters.
 * If the class and the method have the same type parameter, it means that the method is working with the same type as the class.
 * Here's an example:
 *
 * public class GenericClass<T> {
 *     private T item;
 *
 *     public void setItem(T item) {
 *         this.item = item;
 *     }
 *
 *     public <U> void printArray(U[] array) {
 *         for (U element : array) {
 *             System.out.println(element);
 *         }
 *     }
 * }
 *
 * In this example, GenericClass is a generic class with type parameter T,
 * and setItem is a non-static method that uses the same type parameter T. getItemFromArray is a generic method with its own type parameter U.
 * This method can accept arrays of any type and return an element from a specific index.
 */

