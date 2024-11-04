package Generics.lecture.listUtils;


import Generics.lecture.scale.Thing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //basic bahevior:

        List<Integer> integers = List.of(20, 39, 50, 39, 80);

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));

        //------------------------------- behavior with objects that implement Comparable

        Thing th1 = new Thing(8);
        Thing th2 = new Thing(9);
        Thing th3 = new Thing(70);
        Thing th4 = new Thing(-32);
        Thing th5 = new Thing(0);
        Thing th6 = new Thing(70);
        List<Thing> things = new ArrayList<>();
        things.add(th1);
        things.add(th2);
        things.add(th3);
        things.add(th4);
        things.add(th5);
        things.add(th6);

        System.out.println(ListUtils.getMin(things));
        System.out.println(ListUtils.getMax(things));


    }
}
