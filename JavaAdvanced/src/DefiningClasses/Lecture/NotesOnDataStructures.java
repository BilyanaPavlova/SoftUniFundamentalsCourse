package DefiningClasses.Lecture;

//public class NotesOnDataStructures {

    /**
     * Arrays
     *
     * how many bytes has an array in Java for each element
     *
     * In Java, the size of an array element depends on the data type of the array. Here are the sizes for different data types:
     *
     * - boolean: JVM dependent, typically 1 byte
     * - byte: 1 byte
     * - short, char: 2 bytes
     * - int, float: 4 bytes
     * - long, double: 8 bytes
     * - Object: depends on the object (minimum 8 bytes for the object header)
     *
     * For an array of objects, each element is a reference to an object,
     * and the size of a reference is typically 4 bytes on a 32-bit JVM and 8 bytes on a 64-bit JVM.
     * However, the actual size of the object being referenced can vary greatly.
     *
     * Please note that these sizes do not include the overhead of the array object itself,
     * which includes the length of the array and other information.
     * The overhead is typically 12 bytes on a 32-bit JVM and 16 bytes on a 64-bit JVM.
     *
     * -------------------
     *
     * is the address in the memory of each element consecutive for an array? And is searching for an element easy?
     *
     * Yes, in Java, when an array is created, it is allocated a contiguous block of memory.
     * This means that the memory addresses of the elements in the array are consecutive.
     * This is one of the reasons why arrays have a fixed size once created,
     * as expanding the size of the array would require finding a new block of memory that can fit the expanded array.
     *
     * For example, if you have an array of integers, each integer takes up 4 bytes (on most platforms),
     * so the memory address of each subsequent element will be the memory address of the previous element plus 4 bytes.
     *
     * This property of arrays allows for efficient access to its elements,
     * as knowing the base address of the array and the size of each element allows for quick computation
     * of the memory address of any element.
     *
     *---------
     * Adding and removing elements is difficult, because we cannot change the elements' indexes
     * We have to create each time a new array - which is very slow
     * That's why when we work with arrays we usually create some buffers:
     * several cell set to default values at the end so that we don't copy the info each time when we need additional cells
     *
     * Pluses of arrays -> fast reading and finding elements due to calculating the addresses
     * Minuses of arrays -> slow modifications: adding elements, dividing...
     */

    /**
     * LinkedList
     *
     * листът винаги има един елемент (Node), който е Head.
     * Всички останали елементи се достъпват чрез него, защото са разположени
     * на случайни и не последователни кутийки в паметта.
     * ( Не е както при масива, където всички са последователни и адресите им се достъпват
     * като се добавят байтовете на следващия към предходния.)
     * При листа ако загубим адреса на първия, загубваме възможността за достъпване на елементите,
     * защото от първия знаем къде е втория, от втория - къде е третия и т.н
     * така се изчисляват:
     * head - първия
     * head.next - втория
     * head.next.next - третия
     * head.nex.next.next - четвъртия...
     *
     * И листът винаги има Head
     * class LinkedList {
     *
     * Node head; // има глава
     *
     * private static class Node { // има елементи , които са само негови и затова са nested klas -
     *                              нестед класа не е достъпен за вънщния свят и не се ползва от никой друг клас отвън
     *      *     int data;
     *      *     Node next;
     *      *
     *      *     Node(int data) {
     *      *         this.data = data;
     *      *         this.next = null;
     *      *     }
     *
     * }
     *
     * In a singly linked list, each node contains a reference to the next node in the list.
     * The first node in the list is referred to as the head.
     * If you lose the reference to the head, you lose the ability to traverse the list,
     * because there's no way to access the next node without going through the current node.
     *
     * In other words, if you don't know which node is the head, you can't start traversing the list,
     * and thus you can't access any of the nodes in the list.
     * This is because there are no backward references in a singly linked list,
     * only forward references from each node to the next node.
     *
     * Here's a simple illustration:
     *
     * ```java
     * class Node {
     *     int data;
     *     Node next;
     *
     *     Node(int data) {
     *         this.data = data;
     *         this.next = null;
     *     }
     * }
     *
     * class LinkedList {
     *     Node head;  // This is the starting point of the LinkedList
     *
     *     // Other methods to add, remove, or find nodes in the LinkedList
     * }
     * ```
     *
     * In this example, if you lose the reference to `head`, you can't access `head.next`, `head.next.next`, and so on.
     * Therefore, you lose access to the entire list.
     *
     * ----------------
     *
     * check if a list is empty:
     * To create a method that checks if a custom linked list is empty,
     * you would typically check if the head of the list is `null`.
     * If the head is `null`, that means there are no elements in the list, so the list is empty.
     *
     * Here is a simple implementation of this in Java:
     *
     * ```java
     * class Node {
     *     int data;
     *     Node next;
     *
     *     Node(int data) {
     *         this.data = data;
     *         this.next = null;
     *     }
     * }
     *
     * class LinkedList {
     *     Node head;
     *
     *     // Method to check if the list is empty
     *     boolean isEmpty() {
     *         return head == null;
     *     }
     * }
     * ```
     *
     * In this code, the `isEmpty` method returns `true` if the `head` of the `LinkedList` is `null`,
     * indicating that the list is empty. Otherwise, it returns `false`.
     */