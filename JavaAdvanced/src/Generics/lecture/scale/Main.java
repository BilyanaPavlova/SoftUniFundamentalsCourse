package Generics.lecture.scale;

public class Main {

    public static void main(String[] args) {
        Thing thing1 = new Thing(50);
        Thing thing2 = new Thing(10);

        Scale<Thing> scale = new Scale<>(thing1, thing2);
        System.out.println(scale.getHeavier());

    }
}
