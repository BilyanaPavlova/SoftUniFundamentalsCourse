package FunctionalProgramming.Lec;

public class NOTES_Class_manipulate_classes_at_runtime {

/**
 * explain me the difference between this:
 *
 * public static <T> T[] create(int length, T item) {
 * T[] array = (T[]) new Object[length];
 * for (int i = 0; i < array.length; i++) {
 * array[i] = item;
 * }
 * return array;
 * }
 * Check your solution here: https://judge.softuni.bg/Contests/1526/Generics-Lab 15
 * public static <T> T[] create(
 * Class<T> cl, int length, T item) {
 * T[] array = (T[]) Array.newInstance(cl, length);
 * for (int i = 0; i < array.length; i++) {
 * array[i] = item;
 * }
 * return array;
 * }
 *
 *
 * and THis:
 *
 * public static <T> T[] create(
 * Class<T> cl, int length, T item) {
 * T[] array = (T[]) Array.newInstance(cl, length);
 * for (int i = 0; i < array.length; i++) {
 * array[i] = item;
 * }
 * return array;
 * }
 *
 *
 * and elaborate on the second method - why should I need a static method. why in the static method the array is created via Arrai.newinstance, what is the meaning of the Clas<T> cl...
 */

//Answer!!!!

/**
 * The main difference between the two methods is how they create the array of generic type `T`.
 *
 * In the first method:
 *
 * ```java
 * public static <T> T[] create(int length, T item) {
 *     T[] array = (T[]) new Object[length];
 *     for (int i = 0; i < array.length; i++) {
 *         array[i] = item;
 *     }
 *     return array;
 * }
 * ```
 *
 * The array is created by casting a new `Object` array to `T[]`.
 * This is a simple way to create a generic array, but it can lead to `ArrayStoreException` at runtime
 * if you try to store an object that is not of type `T` in the array.
 *
 * In the second method:
 *
 * ```java
 * public static <T> T[] create(Class<T> cl, int length, T item) {
 *     T[] array = (T[]) Array.newInstance(cl, length);
 *     for (int i = 0; i < array.length; i++) {
 *         array[i] = item;
 *     }
 *     return array;
 * }
 * ```
 *
 * The array is created using `Array.newInstance()`, which creates a new array with the specified component type and length.
 * This method is safer because it ensures that the array is of the correct type at runtime.
 *
 * The `Class<T> cl` parameter is used to specify the component type of the array.
 * This is necessary because generic type information is erased at runtime in Java, so you can't create a new array of `T` directly
 * (i.e., you can't do `new T[length]`). By passing in a `Class<T>` object, you can provide the necessary type information at runtime.
 *
 * As for why these methods are static, it's because they don't depend on any instance variables of the class they're in.
 * They only depend on the parameters passed to them, so they can be static.
 * Making them static means you can call them without creating an instance of the class, like this: `ClassName.create(length, item);`.
 *
 * The `Array.newInstance()` method is a native method that creates a new array with the specified component type and length.
 * It's part of the Java Reflection API, which allows you to inspect and manipulate classes, interfaces, fields and methods at runtime.
 * The `Array.newInstance()` method is used here to create a new array of a specific type at runtime.
 */

/**
 * To call the second method, you need to provide the class of the type `T`, the length of the array, and the item to fill the array with.
 * Here's an example of how you can call this method with `Integer` as the type `T`:
 *
 * ```java
 * Integer[] array = create(Integer.class, 10, 5);
 * ```
 *
 * In this example, `Integer.class` is the class of the type `T`, `10` is the length of the array, and `5` is the item to fill the array with.
 * fThe method will return an array of `Integer` of length `10`, filled with the number `5`.
 */

/**
 * In Swift, you can create a similar function using generics and the `Array` initializer.
 * However, Swift doesn't have an exact equivalent to Java's `Array.newInstance()`. Here's how you can create a similar function in Swift:
 *
 * ```swift
 * func create<T>(_ type: T.Type, length: Int, item: T) -> [T] {
 *     let array = Array(repeating: item, count: length)
 *     return array
 * }
 * ```
 *
 * You can call this function like this:
 *
 * ```swift
 * let array = create(Int.self, length: 10, item: 5)
 * ```
 *
 * This will create an array of `Int` of length `10`, filled with the number `5`.
 */

/**
 * translate me this to Java
 *
 * func selectOption<ResultScreen: MSPDFXScreen>(_ option: Options, resultScreenType: ResultScreen.Type) -> ResultScreen {
 *
 *         extendFlexy()
 *
 *         _cell(forOption: option).tap()
 *         return ResultScreen(testCase: _testCase)
 *     }
 */

/**
 * The Swift function you provided seems to be a part of a UI testing suite, possibly using Apple's XCTest framework. It selects an option from a UI and then returns a new instance of a result screen.
 *
 * Java doesn't have an exact equivalent to Swift's XCTest framework. However, you can use a similar approach with a UI testing library like Selenium. Here's a rough equivalent in Java:
 *
 * ```java
 * public <ResultScreen extends MSPDFXScreen> ResultScreen selectOption(Options option, Class<ResultScreen> resultScreenType) {
 *     extendFlexy();
 *
 *     WebElement cell = cellForOption(option);
 *     cell.click();
 *
 *     try {
 *         Constructor<ResultScreen> constructor = resultScreenType.getConstructor(TestCase.class);
 *         return constructor.newInstance(testCase);
 *     } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
 *         e.printStackTrace();
 *         return null;
 *     }
 * }
 * ```
 *
 * In this Java version, `Options` is assumed to be an enum or class that represents the different options that can be selected. `MSPDFXScreen` is assumed to be a class or interface that represents different types of screens in your application. `cellForOption` is a method that returns a `WebElement` representing the cell for a given option. `extendFlexy` is a method that presumably manipulates the UI in some way.
 *
 * Please note that this is a rough translation and might need adjustments based on your actual codebase and the UI testing library you are using.
 *
 * This piece of code is using Java's Reflection API to create a new instance of a class at runtime.
 *
 * Here's a breakdown:
 *
 * 1. `Constructor<ResultScreen> constructor = resultScreenType.getConstructor(TestCase.class);`
 *
 *    This line is getting the constructor of the `ResultScreen` class that takes a `TestCase` as a parameter. The `getConstructor` method is called on the `Class` object `resultScreenType`, which represents the `ResultScreen` class. The `TestCase.class` argument to `getConstructor` specifies that we want the constructor that takes a `TestCase` parameter.
 *
 * 2. `return constructor.newInstance(testCase);`
 *
 *    This line is creating a new instance of the `ResultScreen` class by calling the `newInstance` method on the `Constructor` object. The `newInstance` method takes as arguments the parameters to pass to the constructor. In this case, it's passing `testCase`, which is presumably an instance of `TestCase`.
 *
 * So, in summary, this code is creating a new instance of the `ResultScreen` class using a constructor that takes a `TestCase` parameter, and it's passing `testCase` to that constructor.
 */
}
