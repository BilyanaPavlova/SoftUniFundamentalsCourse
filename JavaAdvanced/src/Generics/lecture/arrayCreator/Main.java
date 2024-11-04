package Generics.lecture.arrayCreator;

import Generics.lecture.scale.Thing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(ArrayCreator.create(9, 3)));
        System.out.println(Arrays.toString(ArrayCreator.create(Thing.class, 3, new Thing(7))));

        System.out.println(Arrays.toString(ArrayCreator.create(9, "abc")));

        // with the first method I can store an object that is not of the declared component type and this will throw an error

        Object[] strings = ArrayCreator.create(9, "abc");
         strings[0] = 1; //Storing element of type 'java.lang.Integer' to array of 'java.lang.String' elements will produce 'ArrayStoreException'

        Object[] strings1 = ArrayCreator.create(String.class, 9, "ab");
        strings1[0] = 1;

//        String[] strings2 = ArrayCreator.create(9, "abc");
//        strings2[0] = 1; //Storing element of type 'java.lang.Integer' to array of 'java.lang.String' elements will produce 'ArrayStoreException'
//
//        String[] strings12 = ArrayCreator.create(String.class, 9, "ab");
//        strings12[0] = 1;
    }

    /**
     *  This behavior is consistent with the second method when you declare the array as a String[]. The key difference between the two methods is how they behave when you declare the array as an Object[].
     *  The first method allows you to assign an Integer to an element of the array (resulting in a runtime error), while the second method does not.
     */
}
