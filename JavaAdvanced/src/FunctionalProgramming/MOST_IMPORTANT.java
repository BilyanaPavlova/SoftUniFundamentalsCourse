package FunctionalProgramming;

public class MOST_IMPORTANT {
    /*
    n functional programming, a stream can receive two types of parameters:
Intermediate Operations: These operations are used to transform the stream into another stream. They are always lazy, executing an intermediate operation such as filter() does not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements of the initial stream that match the given predicate. Some examples of intermediate operations are filter(), map(), flatMap(), sorted(), distinct(), peek(), limit(), skip(), etc.
Terminal Operations: These operations are used to produce a result or a side-effect. After the terminal operation is performed, the stream pipeline is considered consumed, and can no longer be used. Some examples of terminal operations are forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny(), etc.
Here is an example of how these parameters are used in a stream:

List<String> names = Arrays.asList("John", "Jane", "Adam", "Eve");

List<String> filteredNames = names.stream()  // Create a stream
    .filter(name -> name.startsWith("A"))    // Intermediate operation
    .collect(Collectors.toList());           // Terminal operation


    In this example, filter() is an intermediate operation that receives a Predicate (a functional interface) as a parameter, and collect() is a terminal operation that receives a Collector as a parameter.

  Terminal operations in Java streams can receive different types of lambda expressions depending on the operation. Here are some examples:

1. `forEach()`: This operation receives a `Consumer` functional interface. It performs an action for each element of the stream.

```java
stream.forEach(element -> System.out.println(element));
```

2. `reduce()`: This operation receives a `BinaryOperator` functional interface. It performs a reduction on the elements of the stream, using an associative accumulation function, and returns an `Optional`.

```java
Optional<Integer> sum = stream.reduce((a, b) -> a + b);
```

3. `collect()`: This operation receives a `Collector` interface. It performs a mutable reduction operation on the elements of the stream.

```java
List<Integer> list = stream.collect(Collectors.toList());
```

4. `anyMatch()`, `allMatch()`, `noneMatch()`: These operations receive a `Predicate` functional interface. They return whether any elements of the stream match the provided predicate.

```java
boolean allEven = stream.allMatch(num -> num % 2 == 0);
```

5. `min()`, `max()`: These operations receive a `Comparator` functional interface. They return the minimum or maximum element of the stream according to the provided comparator.

```java
Optional<Integer> max = stream.max((a, b) -> a - b);
```

6. `toArray()`: This operation receives an `IntFunction` functional interface. It returns an array containing the elements of the stream.

```java
Integer[] array = stream.toArray(Integer[]::new);
```

Remember that lambda expressions are essentially a concise way to represent a method interface without having a named method. The type of lambda expression a terminal operation can receive depends on the functional interface it is designed to work with.


In Java, there are several built-in functional interfaces. Here are some of the most commonly used ones:

1. `Predicate<T>`: This interface represents a boolean-valued function of one argument. It has an abstract method `tests(T t)` which returns a boolean value.

2. `Consumer<T>`: This interface represents an operation that accepts a single input argument and returns no result. It has an abstract method `accept(T t)`.

3. `Function<T, R>`: This interface represents a function that accepts one argument and produces a result. It has an abstract method `apply(T t)` which returns a result of type `R`.

4. `Supplier<T>`: This interface represents a supplier of results. It does not accept any argument. It has an abstract method `get()` which returns a result of type `T`.

5. `UnaryOperator<T>`: This interface represents an operation on a single operand that produces a result of the same type as its operand. It has an abstract method `apply(T t)`.

6. `BinaryOperator<T>`: This interface represents an operation upon two operands of the same type, producing a result of the same type as the operands. It has an abstract method `apply(T t1, T t2)`.

7. `BiFunction<T, U, R>`: This interface represents a function that accepts two arguments and produces a result. It has an abstract method `apply(T t, U u)`.

8. `BiPredicate<T, U>`: This interface represents a predicate (boolean-valued function) of two arguments. It has an abstract method `tests(T t, U u)`.

9. `BiConsumer<T, U>`: This interface represents an operation that accepts two input arguments and returns no result. It has an abstract method `accept(T t, U u)`.

These functional interfaces are used as targets for lambda expressions and method references. Each of these interfaces has a single abstract method, also known as a functional method.

EXAMPLES:
Sure, here are some examples of using functional interfaces in Java:

1. `Predicate<T>`: This interface is used for lambda expressions that take one argument and return a boolean.

```java
Predicate<String> isLongerThan5 = str -> str.length() > 5;
System.out.println(isLongerThan5.tests("Hello, World!"));  // Prints: true
```

2. `Consumer<T>`: This interface is used for lambda expressions that take one argument and return no result.

```java
Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
printUpperCase.accept("Hello, World!");  // Prints: HELLO, WORLD!
```

3. `Function<T, R>`: This interface is used for lambda expressions that take one argument and return a result.

```java
Function<String, Integer> getLength = str -> str.length();
System.out.println(getLength.apply("Hello, World!"));  // Prints: 13
```

4. `Supplier<T>`: This interface is used for lambda expressions that take no arguments and return a result.

```java
Supplier<LocalDate> getCurrentDate = () -> LocalDate.now();
System.out.println(getCurrentDate.get());  // Prints: current date
```

5. `UnaryOperator<T>`: This interface is used for lambda expressions that take one argument and return a result of the same type.

```java
UnaryOperator<String> reverse = str -> new StringBuilder(str).reverse().toString();
System.out.println(reverse.apply("Hello, World!"));  // Prints: !dlroW ,olleH
```

6. `BinaryOperator<T>`: This interface is used for lambda expressions that take two arguments and return a result of the same type.

```java
BinaryOperator<Integer> multiply = (a, b) -> a * b;
System.out.println(multiply.apply(5, 7));  // Prints: 35
```

7. `BiFunction<T, U, R>`: This interface is used for lambda expressions that take two arguments and return a result.

```java
BiFunction<Integer, Integer, String> sumAsString = (a, b) -> Integer.toString(a + b);
System.out.println(sumAsString.apply(5, 7));  // Prints: 12
```

8. `BiPredicate<T, U>`: This interface is used for lambda expressions that take two arguments and return a boolean.

```java
BiPredicate<Integer, Integer> areEqual = (a, b) -> a.equals(b);
System.out.println(areEqual.tests(5, 5));  // Prints: true
```

9. `BiConsumer<T, U>`: This interface is used for lambda expressions that take two arguments and return no result.

```java
BiConsumer<String, String> printConcatenation = (a, b) -> System.out.println(a + b);
printConcatenation.accept("Hello, ", "World!");  // Prints: Hello, World!
```


     */
}
