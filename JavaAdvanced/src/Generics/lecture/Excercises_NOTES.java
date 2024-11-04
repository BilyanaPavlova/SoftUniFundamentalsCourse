package Generics.lecture;

public class Excercises_NOTES {

    // какво прави компилатора:
    // минава през написания код и проверява за
    //- синтактични грещки
    //- трие коментарите
    // - създаа дефолтен конструктор, ако нямаме такъв
    //- трие типовете на генерициците и каства всички Обекти към съответния тип
    //виж img.png

    // после компилираният код се превежда на машинни команди от Джава виртуалната машина
    // и се изпълнява от нея
    // виж img1.png

    // виж видео за ексерсайзес за дженерици до 38 минута!!!!!

    /**
     * do generic classes have methods that can only be used for any type of data? I suppose they should not have methods that are data specific?
     *
     * Yes, you're correct. Generic classes are designed to be flexible and work with any data type.
     * Therefore, the methods within a generic class should not be specific to any particular data type.
     * Instead, they should operate on the generic type parameter.
     *
     * For example, in the `Box` class you provided, the methods `addElement`, `swap`, and `printSwappedList`
     * all operate on the generic type `T`. They don't make any assumptions about what `T` is, so they can work with any type.
     *
     * However, it's important to note that you can still use methods of the `Object` class
     * (from which all classes in Java inherit) on the generic type. For example, you can call `toString` on `T`
     * because every object in Java has a `toString` method.
     *
     * Here's an example of a method in a generic class that uses `toString`:
     *
     * ```java
     * public class Box<T> {
     *     private T item;
     *
     *     public void printItem() {
     *         if (item != null) {
     *             System.out.println(item.toString());
     *         }
     *     }
     * }
     * ```
     *
     * In this example, `printItem` can be used with any type `T`, because all objects in Java have a `toString` method.
     */

    /**
     * why should I make a class generik if I can make only a method from the class to be generik
     *
     * Making a class generic allows you to define a common behavior for a variety of types,
     * while still maintaining type safety.
     * !!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!This can be particularly useful when you want to create data structures
     * that can hold any type of data, like lists, stacks, queues, trees, etc.
     *
     * On the other hand, making a method generic allows you to define a method that can operate on a variety of types.
     * This can be useful when you want to perform the same operation on different types of data.
     *
     * Here's an example to illustrate the difference:
     *
     * ```java
     * public class Box<T> {
     *     private T item;
     *
     *     public void set(T item) {
     *         this.item = item;
     *     }
     *
     *     public T get() {
     *         return item;
     *     }
     * }
     *
     * public class Utility {
     *     public static <T> void print(T item) {
     *         System.out.println(item);
     *     }
     * }
     * ```
     *
     * In this example, `Box` is a generic class. It can hold an item of any type,
     * and you can get and set the item with type safety.
     * `Utility` is a non-generic class with a generic method `print`.
     * This method can print an item of any type.
     *
     * If you only need a single method to be generic, and the rest of the class doesn't need to be generic,
     * then making just the method generic might be a better choice.
     * !!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!However, if multiple methods in the class need to operate on the same generic type,
     * or if the class represents a data structure that can hold any type of data,
     * then making the class generic might be a better choice.
     */

    /**
     * element.compareТо(otherElement) - този метод го имат само класове, кито имплементират Comparable
     *
     * такива класове са String, Integer. Double, Floqt...
     *
     * когато създадем метод, с който искаме да сравняваме обекти от класове като горните
     * няма проблем да го ползваме compareTo за да ги сравняваме в нашия метод
     *
     * примерно:
     *
     * public static String getMin(List<String> list){
     *     String min = list.get(0);
     *     for(String str : list){
     *         if (str.compareTo(min) < 0){
     *             min = str;
     *         }
     *     }
     *     return min;
     * }
     *
     * когато ОБАЧЕ, решим да ползваме compareTo метода,
     * за да стравняваме обекти от друг тип, различен от тези, които имплементират Comparable итерфейса,
     * тогава трябва на метода ни, който ще е генерик, за да може да работи с различни типове данни,
     * да кажем, че тези типове данни наследяват Comparable и да ги направим наистина да наследяват Comparable
     * Така ограничаваме типовете данни да са само такива, за да могат да ползват compareto метода на интерфейса
     *
     * примерно:
     *
     * public static <Т extends Comparable<T>> Т getMin(List<Т> list){
     *      *     Т min = list.get(0);
     *      *     for(Т el : list){
     *      *         if (el.compareTo(min) < 0){
     *      *             min = el;
     *      *         }
     *      *     }
     *      *     return min;
     *      * }
     *
     * class Pesho implements Comparable () {
     *     .....
     * }
     *
     * List<Pesho> peshos = new List<>();
     * getMin(peshos);
     *
     *  или можем да подадем за тип данни всякакви класове който са наследници на Comparabele: STring, Integer...
     *
     *  List<String> list = new List<>();
     *  getMin(list);
     *
     *
     * значение:
     *
     * public static <Т extends Comparable<T>> Т getMin(List<Т> list){
     *
     * <Т extends Comparable<T>> - ще работи с обекти от такъв тип Т, който наследяват Comparable от Т
     * T - ще връща обект от тип Т
     * (аргументът ще е от тип List<Т> list)
     *
     * ---------------
     * generic class:
     *
     * клас, за който задаваме генерик тип Т, което е някакъв тип, който хората могат да специфицират,
     * когато създават кутията
     *
     * public class Box <T> { // навсякъде въре в кутията ще работим с това, което са ни подали отвън!!!
     *
     * }
     *
     * Box <String> box = new Box<> ();
     * Box <Integer> box = new Box<> ();
     * Box <Pesho> box = new Box<> ();
     */
}
