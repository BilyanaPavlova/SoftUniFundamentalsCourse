package Generics.lecture;

//public class Lecture_Notes {


    /**
     *
     * Purpose of generic classes and methods - type safety and reusability:
     * Allows you to write flexible and reusable classes or functions that can work with any type, while still preserving type safety.
     *
     * Генерик класове се ползват, когато искаме да преизползваме код за различни типове данни.
     * Пример: ArrayList<T> - може да съдържа различни типове данни
     * може да е масив от стрингове, може да е масив от интове и т.н.
     * същественото е това -> за преизползване на код за различни типове данни!!!
     * подаваме тип данни и класът продължава да си работи, без да правим проверки и т.н.
     * затова се ползват генерици  за Листове, мапове, стекове и т.н,
     * т.е. за такива структури, които само съхраняват данните (типовете данни) .!!!!!
     * Генерици използваме точно за такъв тип код, който няма значение какъв е типът данни , с които работими не
     *
     * когато никога не извиквам методи от обекта, който съдържа данните, а само съхраняваме данните
     * това е горе-долу пример, че мога да ползвам обекта с различни типове данни
     * или уначе казано, да бъде генерик
     */

    // когато искаме да създадем обект от клас, който е дженерик, трябва да му кажем с кой тип данни ще работи
    // иначе ще ни даде грешка, че не може да създаде обект от този клас
    //когато създадем наследник на генерик клас, трябва да уточним парънта с какъв тип данни ще работи

//    class Child extends Parent<Pickle> {
//        public Child(Pickle value) {
//            super(value);
//        }
//    }

    // при генерик интерфейси е същото. Когато създаваме интерфейса, трябва да кажем с кой тип данни ще работи

//    interface MyInterface<T> {
//        void add(T element);
//        T get(int index);
//}
//
//class MyClass implements MyInterface<T>
//
//    //навсякъде използваме Т вместо типа на данните, с които ще работим - Т = type
//{
//    @Override
//    public void add(T element) {
//    }
//
//    @Override
//    public T get(int index) {
//        return null;
//    }
//}
/**
 * when we implement a generic interface is it compulsory the class to be generic of the same type?
 *
 * No, it's not compulsory for the implementing class to be generic of the same type as the interface.
 * The implementing class can specify a concrete type for the generic interface. Here's an example in Java:
 *
 * ```java
 * interface MyInterface<T> {
 *     void add(T element);
 *     T get(int index);
 * }
 *
 * class MyClass implements MyInterface<String> {
 *     @Override
 *     public void add(String element) {
 *         // Implementation here
 *     }
 *
 *     @Override
 *     public String get(int index) {
 *         // Implementation here
 *         return null;
 *     }
 * }
 * ```
 *
 * In this example, `MyClass` is not a generic class, but it implements the generic interface `MyInterface` with a concrete type `String`.
 */

/**
 * ВИНАГИ, КОГАТО ИМАМЕ КЛАС< КОЙТО Е ДЕФИНИРАН КАТО ГЕНЕРИ< ТОЙ РЕФЕРИРА КЪМ ИНСТАНЦИЯ, А НЕ КЪМ СТАТИЧНИЯ КОНТЕКСТ
 * ПРАВИЛО: КОГАТО ИМАМЕ СТАТИЧЕН МЕТОД< КОЙТО ИСКАМЕ Д АРАБОТИ С ГЕНЕРИК ПАРАМЕТРИ,
 * ВИНАГИ СЕ ПОСТАВЯ <Т> ПРЕДИ РЕТЪРН ТИПА НА МЕТОДА
 *
 * class ArrayCreator<T> {
 *
    *     public static <T> int[] create(int length, T item) {
 *
 *     }
 *
 *     ПРОБЛЕМ С ГЕНЕРИЦИТЕ В ДЖАВА:
 *     1. НЕ МОЖЕМ ДА СЪЗДАДЕМ МАСИВ ОТ ГЕНЕРИЧЕН ТИП ДАННИ
 *     T[] array = new T[10]; - това не може да се направи
 *     ЗАЩО? Защото на компилатора му трябва да се каже с какъв тип данни ще работи масива
 *     за да знае колко памет да задели при създаването на масива с думата new
 *     Затова се ползва Array.newInstance(T.class, 10); - това е рефлексия
 *     примерно:
 *     class ArrayCreator {
 *
 *     public static <T> int[] create(int length, T item) {
 *     T[] array = (T[]) Array.newInstance(item.getClass(), length);
        return array;
 *     }
 *
 *     item.getClass() - взима типа на данните, с които работим,
 *     в случая на T item - взима типа на item и го подава на Array.newInstance като параметър,
 *     за да създаде масива като задели място в паметта за този тип данни
 *     т.е. тук не даваме елемента, а даваме на елемента класа чрез метода getClass()
 *
 *     може да се разпише и така:
 *     class ArrayCreator {
 *  *
 *  *     public static <T> Т[] create(int length, T item) {
 *  *     Class<?> clazz = item.getClass();  // взимаме класа на item. Пишем го с clazz, защото Class запазена дума за създаване на клас
 *  *     T[] array = (T[]) Array.newInstance(clazz, length);
 *
 *        Arrays.fill(array, item); // запълваме масива с item
 *
 *         return array;
 *  *     }
 *
 *        Array.newInstance(clazz, length); // това връща обект от тип Object, затова трябва да го кастнем към T
 *        (T[]) Array.newInstance(clazz, length); // кастваме го към T. Тук кастването е задължително
 *
 *        извикваме го по следния начин:
 *        int[] array = ArrayCreator.create(10, 0);  //създай нов масив с дължина 10 и дефолтна стойност 0
 *        или така
 *        int[] array = ArrayCreator.<Integer>create(10, 0);
 *        <Integer> не е задължително, защото компилатора може да разбере от параметъра 0, че това е инт
 *
 *        може и така да го създадем:
 *        public static <T> Т[] create(Class<?> clazz, int length, T item) { //подаваме класа като параметър, като ? е wildcard, т.е. може да е всеки тип данни
 *       T[] array = (T[]) Array.newInstance(clazz, length);
 *       }
 *        тогава го извикваме по следния начин:
 *        int[] array = ArrayCreator.create(Integer.class, 10, 0); // създаваме масив от интове с дължина 10 и дефолтна стойност 0
 *
 *        В практиката няма да ни се налага да създаваме масиви от генерични типове данни,
 *        защото има вградени колекции като ArrayList, които се грижат за това
 *        Но ако ни се наложи, можем да ползваме този метод
 *
 *        ОБОБЩЕНИЕ: В джава не можем да създаем нов обект от генеричен клас , т.е да кажем new T();
 *        както и не можем да създадем нов масив от генеричен тип данни, т.е. new T[10];
 *        защото не можем да създадем нова памет, без да знаем типа данни, за които ще заделяме съответното количество памет
 *        затова се ползва
 *        (T[])Array.newInstance(clazz, length, item);
 *
 *        като взимаме класа на обекта, с който работим, и подаваме този клас като параметър на Array.newInstance
 *         public static <T> Т[] create(Class<?> clazz, int length, T item) { //подаваме класа на обекта като параметър, като ? е wildcard, т.е. може да е всеки тип данни
 *  *       T[] array = (T[]) Array.newInstance(clazz, length);
 *  *       }
 *
 *
 *     2. НЕ МОЖЕМ ДА СЪЗДАДЕМ ИНСТАНЦИЯ ОТ ГЕНЕРИЧЕН КЛАС
 *     T t = new T(); - това не може да се направи
 *     Защото компилатора не знае с какъв тип данни ще работи този обект
 *--------------------
 * генериците са илюзия на компилатора
 * те се използват само по време на компилация
 * след това се изтриват и няма да ги има в байткода
 * това се нарича type erasure
 * т.е. компилатора се грижи за типовете данни по време на компилация, но след това те изчезват
 * и няма да ги има в байткода
 *
 *  с instanceof не можем да проверим дали е обект от даден тип данни
 *  защото те са изтрити от компилатора
 *  не можем да направим така:
 *  if (list instanceof List<Integer>) {
 *  но можем да направим така:
 *  if (list instanceof List) {
 *  можем да го направим с .getClass() == типа данни
 *  или с .getClass().getSimpleName().equals("типа данни")
 *  или с .getClass().getName().equals("типа данни")
 *  или с .getClass().getTypeName().equals("типа данни")
 *  или с .getClass().getCanonicalName().equals("типа данни")
 *
 *  ----------
 *  var
 *  ползва се когато типът на данните е ясен , но е много дълъг и не искаме да го изписваме целия, примерно:
 *  var list = new ArrayList<Integer>(); - тук не пишем ArrayList<Integer> list = new ArrayList<Integer>();
 *  for (var element : list) {
 *  или
 *  for(Map.Entry<String, Integer> entry : map.entrySet()) {
 *  може да се замести с
 *  for (var entry : map.entrySet()) {
 *
 *ако натиснем алт + ентър върху var, ще ни даде опция да го замени с истинския тип данни
 *работи само ако съм инициализирала променливата на същия ред , на който съм я декларирала
 * не работи така:
 * var list;
 * list = new ArrayList<Integer>();
 * и да дам алт+ ентър върху var
 */

/**
 * What is a static method used about?
 *
 * A static method in Java is a method that belongs to the class rather than an instance of the class.
 * This means you can call the method without creating an instance of the class.
 * STATIC GENERIC METHODS ARE OFTEN USED FOR UTOLITY OR HELPER METHODS THAT DON"T REQUIRE ANY OBJECT STATE!!!!!
 * YOU CAN CALL THEM DIRECTLY ON THE CLASS!!!!!!!!
 *
 * public class MathUtils {
 *     public static int add(int a, int b) {
 *         return a + b;
 *     }
 * }
 * ---------
 *
 * What is a static generic method used about?
 *
 * A static generic method in Java is a method that belongs to the class rather than an instance of the class,
 * and it can work with different types of data.
 * This means you can call the method without creating an instance of the class,
 * and you can use it with different types of data.
 *
 * Static generic methods are often used for utility or helper methods that don't require any object state
 * but need to work with different types of data.
 * They are also useful when you want to perform operations that are independent of the type of objects.
 *
 * Here's an example of a static generic method in Java:
 *
 * ```java
 * public class Utils {
 *     public static <T> void printArray(T[] array) {
 *         for (T element : array) {
 *             System.out.println(element);
 *         }
 *     }
 * }
 * ```
 *
 * In this example, `printArray` is a static generic method that can print arrays of any type.
 * The `<T>` before the return type of the method indicates that this method will be dealing with generic type `T`.
 * You can call this method directly on the class, like this:
 *
 * ```java
 * Integer[] intArray = {1, 2, 3};
 * Utils.<Integer>printArray(intArray);
 *
 * String[] strArray = {"Hello", "World"};
 * Utils.<String>printArray(strArray);
 * ```
 *
 * In the above code, `printArray` method is called with an array of integers and an array of strings. The method works correctly in both cases, demonstrating the use of static generic methods.
 * -------------------
 *
 * can I define a generic method in a Java non generic class
 *
 * Yes, you can define a generic method in a non-generic class in Java.
 * The scope of the type parameter is limited to the method where it is declared.
 * Here is an example:
 *
 * ```java
 * public class NonGenericClass {
 *
 *     public <T> void printArray(T[] array) {
 *         for (T element : array) {
 *             System.out.println(element);
 *         }
 *     }
 * }
 * ```
 *
 * In this example, `printArray` is a generic method defined in a non-generic class `NonGenericClass`.
 * This method can accept arrays of any type and print their elements.
 *
 * -------------------------
 *
 * can I define a static generic method in a java non-generic class?
 *
 *Yes, you can define a static generic method in a non-generic class in Java.
 * The scope of the type parameter is limited to the method where it is declared.
 * Here is an example:
 *
 * ```java
 * public class NonGenericClass {
 *
 *     public static <T> void printArray(T[] array) {
 *         for (T element : array) {
 *             System.out.println(element);
 *         }
 *     }
 * }
 * ```
 *
 * In this example, `printArray` is a static generic method defined in a non-generic class `NonGenericClass`.
 * This method can accept arrays of any type and print their elements.
 *
 * -------------------------
 *
 * are there static generic methods in swift
 *
 * Yes, Swift does support static generic methods.
 * In Swift, you can define a generic method inside a generic or non-generic type (class, struct, or enum).
 * Here's an example of a static generic method in Swift:
 *
 * ```swift
 * struct Utils {
 *     static func printArray<T>(_ array: [T]) {
 *         for element in array {
 *             print(element)
 *         }
 *     }
 * }
 * ```
 *
 * In this example, `printArray` is a static generic method that can print arrays of any type.
 * You can call this method directly on the struct, like this:
 *
 * ```swift
 * let intArray = [1, 2, 3]
 * Utils.printArray(intArray)
 *
 * let strArray = ["Hello", "World"]
 * Utils.printArray(strArray)
 * ```
 *
 * In the above code, `printArray` method is called with an array of integers and an array of strings.
 * The method works correctly in both cases, demonstrating the use of static generic methods in Swift.
 */

/**
 * -------------------------
 * GENERIC TYPE PARAMETER BOUNDS
 *
 * Generic type parameter bounds in Java are used to restrict the types
 * that can be used as type arguments in a generic class or method.
 * For example:
 * public class MyClass<T extends Animal> {}
 *
 * call:
 * MyClass<Dog> myClass = new MyClass<>(); //Dog extends Animal
 * MyClass<WashingMashine> myClass = new MyClass<>(); - impossible WashingMashine does not extend Animal
 *
 * по този начин огранчаваме типовете данни, които могат да бъдат подадени като параметри на генеричния клас
 * т.е. ще подавам само такива типове данни, които наследяват Animal и които ползват същите методи и полета като Animal
 *
 * когато имам сравнение на генерични типове данни, трябва да се използва equals() метода, защото == сравнява референциите
 * a генеричните типове данни са обекти и трябва да се сравняват с equals()
 *
 * при срваняване < или > на обекти, ползваме compareTo() метода
 *но за да го ползваме, трябва класа да имплементира Comparable интерфейса
 * примерно:
 * public class MyClass<T extends Comparable<T>> {
 *     public int compare(T first, T second) {
 *     return first.compareTo(second);
 *     }
 *
 *     In Java, the keyword extends is used in the context of generics to mean "extends or implements".
 *     It's a bit of a misnomer, but it's the terminology that Java uses.
 *     In the class declaration public class MyClass<T extends Comparable<T>>,
 *     the extends keyword is used to indicate that the type parameter T must be a type that extends or implements Comparable<T>.
 *     This is known as a bounded type parameter.
 * In the context of Java generics, the keyword `extends` is used to denote both class inheritance (extends) and interface implementation (implements).
 * This might seem a bit confusing because the keyword `extends` is used, but it's the terminology that Java uses.
 *
 * So, when you see a declaration like `public class MyClass<T extends Comparable<T>>`,
 * it means that `T` must be a type that either extends a class or implements an interface `Comparable<T>`.
 * In this case, `Comparable<T>` is an interface, so `T` must be a type that implements `Comparable<T>`.
 *
 * The reason we don't use `implements` in this context is simply because that's the syntax defined by the Java language specification.
 * The `extends` keyword is used for both class extension and interface implementation when defining a bounded type parameter in Java generics.
 *
 * така ще мога да сравнявам класове от Comparable
 *
 * public class ListUtils {
 *
 * public static <T extends Comparable<T>> T getMax(List<T> list) {
 * if (list.isEmpty()) {
 * throw new IllegalArgumentException("List is empty");
 * }
 *
 * return Collections.max(list);
 * }
 *
 * public static <T extends Comparable<T>> T getMin(List<T> list) {
 * if (list.isEmpty()) {
 * throw new IllegalArgumentException("List is empty");
 * }
 * return Collections.min(list);
 *
 * }
 *
 * call the methods:
 * List<Integer> numbers = List.of(1, 2, 3, 4, 5);
 * System.out.println(ListUtils.getMax(numbers));
 * System.out.println(ListUtils.getMin(numbers));
 *
 * List<String> strings = List.of("a", "b", "c", "d", "e");
 * System.out.println(ListUtils.getMax(strings));
 * System.out.println(ListUtils.getMin(strings));
 *
 *
 *
 *
 */