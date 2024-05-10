package FunctionalProgramming.Lec;

import java.util.function.Predicate;

public class Lec5_Predicate_Chaining {
    public static void main(String[] args) {

        //когато работим с предикати можем да ги чейнваме функциите с and или or

        Predicate<Integer> isGreaterThanTen = x -> x > 10;
        Predicate<Integer> isEvan = x -> x % 2 == 0;

        //chaining predicates
        int number = 42;
        if(isGreaterThanTen.and(isEvan).test(number)){
            System.out.println(number);
        };

        if(isGreaterThanTen.or(isEvan).test(number)){
            System.out.println(number);
        };

        // ползване на предиката - с функцията .test()
        isGreaterThanTen.test(10);
    }
}
