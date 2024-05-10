package FunctionalProgramming.Lec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lec1_Sort {

//Write a program that reads one line of Integers separated by ", ".
//· Print the even numbers.
//· Sort them in ascending order.
//· Print them again.
//Use 2 Lambda Expresions to do so.

    public static void main(String[] args) {



        List<String> numbers = List.of("45", "32", "43", "22", "80", "12");

                numbers.stream()
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

//        Collections.sort(nums); // променя данните в листа

        // принтира преди сортирането, защото горния стрийм не ги е сортирал, и е терминирал в лист
        numbers.forEach(System.out::println);

        // пускаме стрийм със сорт по горния лист и терминираме с принт
        numbers.stream()
                .sorted()
                .forEach(System.out::println); // не променя данните в ллиста, а променя само в стрийма

// 2 готини свойства на стрийма:
//        - стриймът не променя опбектът, по който е пуснат потока
//        - стриймът се изпълнява, когато има терминираща операция - collect, forEach
//        - ако имам променлива, която е външна за потока и се опитам да я модифицирам в една laмbda функция,
//        това няма да работи! Което гарантира, че при ползването на функционално програмиране,
//        няма да има странични ефекти (промчна на външна променлива е страничен ефект)

        //разпечатване на stream на един ред на несортираните:
        System.out.println(numbers.stream()
                .map(String::valueOf)// преврщаме в стрингове
                .collect(Collectors.joining(", ")));

        //разпечатване на stream на един ред на сортираните:
        System.out.println(numbers.stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")));
        System.out.println("Functional Interfaces ==============================================");

        // Function - функционален интерфейс с един метод apply() - ползва се за дефиниране на функции
        // може да се напище лесно, като вместо да се овърайдва, се ползва lambda

        Function<Integer, Integer> square = x -> x * x;
        // Function<T, R>
        // T = параметърът, който функцията приема,
        // R - резултатът (променливата), която функцията връща
        //  x -> x * x - функцията какво прави с lambda

        int result = square.apply(5); // подаваме параметър на аплай метода на функционалния интерфейс
        System.out.println(result);
    }

}
