package Generics.lecture.jarOfPickles;

public class Main {
    public static void main(String[] args) {
        Pickle p1 = new Pickle(1);
        Pickle p2 = new Pickle(4);
        Pickle p3 = new Pickle(2);

        Jar<Pickle> jarOfP = new Jar<>();

        jarOfP.add(p1);
        jarOfP.add(p2);
        jarOfP.add(p3);

        Pickle removed = jarOfP.remove();
        System.out.println(removed);

        System.out.println(jarOfP);

    }
}
