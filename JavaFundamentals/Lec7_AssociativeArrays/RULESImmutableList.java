package Lec7_AssociativeArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RULESImmutableList {
    public static void main(String[] args) {

        //List is immutable!!!!!!!!!!!!!!! when created as List:

        // if you use Arrays.asList() to create a list from an array,
        // the resulting list is backed by the array, but it is not resizable.

        List<String> immutableList = Arrays.asList("a", "b", "c"); //!!!!!!!!!!! IMMUTABLE
//        immutableList.add("d"); //UnsupportedOperationException

        //In summary, a List is immutable when it is explicitly created as an immutable list
        // using methods like Collections.unmodifiableList(), List.of(), or List.copyOf().

        List<String> immutableList1 = List.of("a", "b", "c");
        System.out.println(immutableList1);
//        immutableList1.add("d"); //UnsupportedOperationException

        List<String> immutableList2 = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
//        immutableList2.add("d");//UnsupportedOperationException

        //!!!!!!!!!!!!!!!!!!!!!!!
        // ArrayList, LinkedList, and other implementations of the List interface
        // ARE MUTABLE by default.
        // You can add, remove, or modify elements in these lists.

        //за да е MUTABLE винаги го създаваме като ArrayList/LinkedList, на който подаваме immutable, създаден като Arrays.asLIst()

        List<String> mutableList = new ArrayList<>(Arrays.asList("a", "b", "c")); //!!!!!!!!!!!!!!!!!!!!MUTABLE
        mutableList.add("d"); // this works
        System.out.println(mutableList);

        List<Integer> mutableListInt = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(mutableListInt);


//        The Arrays.asList() method in Java is used to convert an array into a List object.
//        It allows you to quickly create a fixed-size list backed by the specified array.

        String[] array = {"a", "b", "c", "d"};

        // Convert the array to a List using Arrays.asList()
        List<String> list = Arrays.asList(array); //fixed-size list

        System.out.println("List: " + list);

        /*In this example, the Arrays.asList(array) call creates a List of strings
        from the specified String array. The resulting list is backed by the original array,
         which means any changes made through the list are reflected
         in the underlying array and vice versa.*/

        list.set(0, "T");
        System.out.println(array[0]); // changing the list , will change the backing array

/*It's important to note that the resulting List is a fixed-size list,
which means you cannot add or remove elements from the list.
Attempting to modify the size of the list (e.g., by using add() or remove())
will result in an UnsupportedOperationException. However,
you can modify the elements within the list (e.g.,
 by using set() to change the value of an existing element).*/

        List<String> makingImmutableToMutable = new ArrayList<>(list);
        makingImmutableToMutable.add("K");
        System.out.println(makingImmutableToMutable);


        

    }
}
