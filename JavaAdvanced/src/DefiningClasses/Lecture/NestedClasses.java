package DefiningClasses.Lecture;

public class NestedClasses {

    /**
     * Nested classes, also known as inner classes, are used in Java for various reasons:
     *
     * 1. **Logical grouping of classes**: If a class is useful to only one other class,
     * then it is logical to embed it in that class and keep the two together.
     * Nesting such "helper classes" makes their package more streamlined.
     * The inner class members will be visible only to the outer class
     *
     * 2. **Increased encapsulation**: Consider two top-level classes, A and B,
     * where B needs access to members of A that would otherwise be declared private.
     * By hiding class B within class A, A's members can be declared private and B can access them.
     * In addition, B itself can be hidden from the outside world.
     *
     *
     * 3. **More readable, maintainable code**: Nesting small classes within top-level classes places the code closer
     * to where it is used.
     *
     * Here's an example of a nested class in Java:
     *
     * ```java
     * public class OuterClass {
     *     private int myVariable;
     *
     *     public class InnerClass {
     *         public void accessOuter() {
     *             System.out.println("Outer variable: " + myVariable);
     *         }
     *     }
     * }
     * ```
     *
     * In this example, `InnerClass` is a nested class within `OuterClass`.
     * It can access the private members of `OuterClass`, which increases encapsulation.
     */
}
