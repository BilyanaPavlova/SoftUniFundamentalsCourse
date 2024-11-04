package FunctionalProgramming.Lec;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Stream;

public class NOTES {

    public static void main(String[] args) {

/* Functional programming in Java refers to a programming paradigm that treats computation
as the evaluation of mathematical functions and avoids changing-state and mutable data.
Java, being an object-oriented programming language, started incorporating functional programming features
since the introduction of Java 8 with the addition of lambda expressions,
functional interfaces, and the Stream API.

Here are some key concepts and features of functional programming in Java:

1. Lambda Expressions: Lambda expressions allow you to treat functionality as a method argument,
or to create instances of functional interfaces more concisely.
They provide a way to define anonymous functions in Java. For example:
// Lambda expression to define a function that adds two integers
BinaryOperator<Integer> add = (a, b) -> a + b;

Functional Interfaces: Functional interfaces are interfaces that have exactly one abstract method.
They can be implemented using lambda expressions, method references,
or anonymous inner classes. Examples include Runnable, Comparator, Consumer, etc.
// Functional interface
@FunctionalInterface
interface MyFunctionalInterface {
    void doSomething();
}

3.Stream API: The Stream API introduced in Java 8 provides a fluent and functional way
 to process collections of objects. It allows you to perform aggregate operations on collections
 such as filtering, mapping, reducing, and more, using functional programming idioms.
 for ex:
 List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Using Stream API to filter and sum the even numbers
int sumOfEvenNumbers = numbers.stream()
                              .filter(n -> n % 2 == 0)
                              .mapToInt(Integer::intValue)
                              .sum();


4. Immutable Data: Functional programming promotes immutability, meaning that once an object is created,
its state cannot be changed. In Java, you can achieve immutability by using final keyword for fields
and creating immutable classes.
5. Higher-Order Functions: Functions that take other functions as arguments or return functions
are called higher-order functions. While Java lacks full support for higher-order functions,
lambda expressions provide a way to emulate them to some extent.
6. Pure Functions: Pure functions are functions whose output is solely determined by their input parameters
and have no side effects. While it's not enforced in Java, writing pure functions can lead to more predictable
and maintainable code.

Functional programming in Java promotes concise and readable code by emphasizing the use of functions
and immutable data. It encourages writing code that is easier to reason about, tests, and parallelize.
While Java is primarily an object-oriented language, the addition of functional programming features
has made it more versatile and expressive.
*/

        //функц. прогр. -> изпълнява lambda expressions = изпълнява анонимни функции (такива, които не са дефинирани
        // в отделен метод и не могат да бъдат викани многократно
        //
        //  .stream -> терминиращи и нетерминиращи операции върху стрийма:
        // - нетерминиращи: .filter().map() и др.
        // могат да бъдат навързвани една след друга върху стрийма,
        // но те не променят първоначалната структура от данни, върху която е пуснат стрийма,
        // порменят само самия стрийм, т.е. изпълняват някаква работа върху стрийма
        // резултатът им може да бъде асайнат на стрийм клас чрез терминираща операция
        // и да бъде ползван по-късно в кода, когато ни потрябва,
        // примерно след някаква проверка, която да пуска резултата от стрийма

        // терминиращи - викат резултата от работата по стрийма и могат да го асайнат на необходимата структура
        // прикключват стрийма, след тях не може да се навързват други операции
        // чрез тях можем, когато ни потрябва на друго място в кода,
        // да извикаме резултата от работата на нетерминиращите операции, пуснати по стрийма
        // примерно: stream.forEach(System.out::println)
        // stream.collect

        List<Integer> numbers = List.of(49, 13, 23, 42, 52);

        // КАКВО ПРАВИ (lambda): филтрира само нечетни, сортира филтрираните, вдига ги на квадрат -
        // всичко това го прави върху стрийма, а не променя numbers.
        // свършената работа остава нетерминирана в стрийма
        Stream<Integer> stream = numbers.stream()
                .filter(n -> n % 2 != 0)
                .sorted((f, s) -> Integer.compare(f, s))
                .map(n -> n * n);

        //по-нататък в кода - някакв апроверка и ако да, изпълняваме работата от стрийма/ терминираме
        if (true) {
            stream.forEach(n -> System.out.println(n));
        }


        // lambda - могат да са с 1 параметър .filter(n -> n % 2 != 0)
        // с 0 параметри (() -> System.out.println ("Hello"))
        // с много параметри ((f, s, m) -> f * s * m)
        // когато са 0 или много са в скоби

        // метод референция - (още по-съкратения вариант на lambda, когато се изпълнява за всеки един елемент):
        // .map(Integer::parseInt) // подава класа и метода
        // само подаваме като референция методът, който трябва да се изпълни
        // не е нужно да пишем, че за всеки елемент трябва да се изпълни, то знае
        // примерно да пишем .map(e -> Integer.parseInt(e))

        // това се ползва и при методът forEach() на List. Листовете имате метод forEach()
        // прим: numbers.forEach(System.out::println) - метод референция, който се изпълнява за всеки ел от листа

        //=================
//    Functional interfaces:

//    Function <T, R> - приема Т, прави нещо с ламбда с него и връща резултат от R тип
        //Function<String, Integer> parseString = Integer::parseInt;
        //Function<String, String> function = s -> "Hello + s";

//    UnaryOperator<String> unaryOperator = s -> "Hello + s"; - приема 1, връща един - от еднакъв тип данни
        // реално е същият като Function , но е глупако устойчив - гарантира, че ще има само 1 аргумент от един и същ тип
        // - какъвто тип приема, такъв тип връща

//    Predicate<T> - тества с функцията си tests, връща булин, примерно се ползва при filter на стриймовете
// Predicate<String> predicate = s-> s.lenghth() > 5;
// In Java functional programming, Predicate<T> is a functional interface
// that represents a boolean-valued function of a single argument.
// It's commonly used to define conditions or filters when working with collections or streams of elements.

//    Supplier<T> - method get, който предоставя нещо, често се ползва за инициализиане на обекти
//Supplier-a не приема никакви аргументи и връща един
//    Supplier<String> supplier = ()-> "Pesho";

        // Consumer <T> - функционален интерфейс, който приема параметър от тип Т и не връща нищо (аналог на void)
        // има един метод void accept(T t) , който е void и не връща нищо
        // Consumer<String> consumer = System.out::println;

        //БиФункции - същите като функциите, но просто приемат още един аргумент. т.е. приемат 2 и връщат един
//    BiFunction<String, Integer, Integer> biFunction = (text, number) -> text.length() + number;
        //приема 2 аргумента и връща един
//    BiPredicate<String, String> biPredicate = (text1, text2) -> text1.length() > text2.length();
//BiConsumer<String, String > biConsumer = (t1, t2) -> System.out.println(t1 + t2);
// BiSupplier - не можем да имаме, защото, СУпл не проема никакви аргументи и връща 1. Не можем да върнем 2 нещще еедновременно

//   BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 + num2;
        //приема 2 аргумента, връща един
//    !!!при операторите винаги всички аргументи са от еднакъв тип данни,
//    затова само един се подава <Integer> (както и при UnaryOperator)

//    ----
//    Можем сами да си правим функционални интерфейси, като ги тагнем като функц интерфейси.
//    това означава, че това са интерфейси, които имат само един единствен  метод

        @FunctionalInterface
        interface Converter {
            String transformString(String text);
        }

        //ползване
        // в мейн метода си правя един converter, който искам да прием астринг и да връща трансформиран стринг
        Converter converter = text -> text + "Good bye";

        //така можем сами да си направим и функции, които да приемат по три и повече аргументи.
        // В Java има готови функции само до приемащи 2 аргумента и връщащи 1

        //генерик интерфейс, който да приема 3 агрумента и да връща 1 R резултат - дефинирано в отделен интерфейс
        @FunctionalInterface
        interface TriFunction<T, F, S, R> {
            R triFunction(T t, F f, S s);
        }

        //    ползване
        TriFunction<String, String, String, String> tri = (text1, text2, text3
        ) -> text1 + text2 + text3;
        String r = tri.triFunction("Hi ", "Pesho, ", "How are you?");


//КАКВА Е РАЗЛИКАТА МЕЖДУ ФУНКЦИЯ И МЕТОД:
//    Методът принадлежи на даден клас и може да се извика, само ако имаме инстанция на някакъв обект към даден клас, или към даден  клас.
//    Функцията може да се извика анонимно, не е необходим да принадлежи на даден клас!!!

        //п.п. въпреки че отдолу нещата пак се изпълняват с интерфейси и реално функционалното програмиране в Джава не е много функционално -
        // т.е. методът на интерфейса, пак принадлежи на даден интерфейс

        //---
//    ctrl + shift + P - след stream().показва докъде сме стигнали или какво тече в нащия стрийм

        //-------
        //примитивни стриймове:

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        
        list.stream().map(Integer::parseInt); // връща стрийм от Integer-i Stream<Integer>
        list.stream().mapToInt(Integer::parseInt); //връща стрийм от примитивни данни инт IntStream (примитивни стриймове) -> имат функции за sum, average, max...


        list.stream().map(Integer::parseInt).toArray(); //- връща масив от Object
        list.stream().map(Integer::parseInt).toArray(Integer[]::new); // така ще върне масив от голям Интегер

        //други примитивни стриймове: DoubleStream, LongStream - достъп до min, max, average, sum и др.

        //---------

        Optional<String> op = Optional.of("Pesho");
        // опшънълът е нещо като обвивка, която позвоялва да питаме дали вътре имаме/нямаме нещо и ако имаме да си го извлечем

        op.isEmpty();
        op.get();

        Optional<String> opt = Optional.of(null);
        System.out.println(opt.orElse("Nothing")); // защитава ни от нул, ако опш върне ниюо, знаем какво да правим

        //при смятане на ср аритм или макс - може да има ама може и да няма резултат. Тогава се връща опшънъл и тр да помислим какво искаме да направим ако няма
        // ср. аритм на 1 + 2 = 1.5.
        double d = list.stream().mapToInt(Integer::parseInt).average().orElse(9);
        double m = list.stream().mapToDouble(Double::parseDouble).max().orElseThrow(() -> new IllegalArgumentException());
    }
}
