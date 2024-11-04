package DefiningClasses.Workshops_DataStructures;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.jar.JarOutputStream;

public class Main {
    public static void main(String[] args) {

        CustomLinkedList myList = new CustomLinkedList();

        System.out.println(myList.isEmpty());
        myList.addFirst(2);
        myList.addFirst(1);
        myList.addFirst(0);
        myList.addLast(5);
        myList.addLast(6);
//
//        System.out.println(myList);
//        System.out.println(myList.get(4));
//        System.out.println(myList.get(0));
//        System.out.println(myList.get(1));




//        System.out.println("first " + myList.removeFirst());
        System.out.println(myList);
        System.out.println("last " + myList.removeLast());

        System.out.println(myList);

        myList.forEach(e -> System.out.println(e + 3));

        System.out.println(Arrays.toString(myList.toArray()));


    }
}
