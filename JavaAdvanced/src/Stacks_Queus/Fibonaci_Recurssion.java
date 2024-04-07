package Stacks_Queus;

import java.util.Scanner;

public class Fibonaci_Recurssion {

    public static long[] calculatedFibonachies;

    public static void main(String[] args) {
//        1, 1, 2, 3, 5, 8, 13, 21, 34...
//        0  1  2  3  4  5  6   7   8

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        //инициализираме масив с дължина колкото са числата -> всичките му елементи са = 0 в началото
        // в него ще пазим изчислените един път числа на фибоначи
        // това е при решението с мемоизейшън
        // при другото решение само с рекурсия , го няма този масив
        calculatedFibonachies = new long[n + 1]; // n + 1 заради нулевия индекс

        System.out.println(fibAtIdx(n));
    }

    private static long fibAtIdx(int n) {

        // ако са първите 2 числа, винаги връща 1 и приключва програмата
        if (n < 2) {
            return 1;
        }

//        // ако са следващите чиасла, изчислява сбора на предходните две - ползва рекурсия
//        // задачата може да приключи дотук, но така се ползва много памет за изчисляване на фибоначи на едни и същи позиции по няколко пъти
//        // затова се ползва memoization на джава
//        return fibAtIdx(n-1) + fibAtIdx(n-2);
//-------------------------

        //решение с мемоизация:
        //мемоизатион всяко изчислено вече фибоначи се записва в масив, със същия размер като n и се взима от там
        // ако при взимане е = 0, значи е празно и тр да запишем
        // ако при взимане е != 0 значи го взимаме и го показваме

        if (calculatedFibonachies[n] != 0) {
            //върни числото от масива
            return calculatedFibonachies[n];
        }

        // ако не е записано в масива и е 0, изчисли го, запиши го и върни го:
        calculatedFibonachies[n] = fibAtIdx(n - 1) + fibAtIdx(n - 2);
        return calculatedFibonachies[n];


    }
}
