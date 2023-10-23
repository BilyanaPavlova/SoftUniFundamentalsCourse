package MidExamPrep;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class ListFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(sc.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

//       intList.remove(Integer.valueOf(5)); премахва елемент, ако съществува в
//листа. Ако елемента е примитивен тип данни (double, int), чрез ValueOf() трябва да го превърнем в
//референтен тип данни, за да знае компилатора, че това е елемент. Ако го оставим int компилатора ще
//припознае числото като индекс, а не като елемент от листа.
// Ако елемента не съществува няма да ни даде ексепшън, просто ще игнорира командата.!!!
        intList.remove(Integer.valueOf(5));
        System.out.println(intList);

//        Ако го оставим int компилатора ще
////припознае числото като индекс, а не като елемент от листа.
        intList.remove(5);

//        ----------------
//        integerList.addAll(numList) – може да добавим всички елементи от една колекция в
//друга. Добавят се в края на колекцията.

        List<Integer>integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.addAll(intList);

        System.out.println(integerList);

//        Collections.sort(integerList)- сортираме елементите в листа
        Collections.sort(integerList);
        System.out.println(integerList);

//        Collections.reverse(integerList) – обръщаме реда на елементите в листа, независимо
//        от това дали са сортирани или не.
        Collections.reverse(integerList);
        System.out.println(integerList);



    }
}
