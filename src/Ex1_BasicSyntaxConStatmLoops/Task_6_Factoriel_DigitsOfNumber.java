package Ex1_BasicSyntaxConStatmLoops;

import java.util.Scanner;

public class Task_6_Factoriel_DigitsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int number = Integer.parseInt(sc.nextLine());


        while (true) { // стартира луп за въвеждане на числа от конзолата

            int initialNumber = number;

            int sum = 0;

            //алгоритъм за взимане на цифрите на число и калкулиране на факториал и сумата от факториалите на тези цифри
            while (number > 0) {

                // 1.взимаме последната цифра на числото
                int d = number % 10;

                //2. обработваме цифрата каквото искаме да я правим - в случая изчисляваме факториала и
                int factoriel = 1; // декларираме факториала в while loop-a , за да може всеки път да се
                                    // занулява при всеки цикъл, защото е факториел и трябва да почва от 1
                                    // ако се декларира извън while loop-a няма да се занулява всеки път!!!
                for (int i = 1; i <= d; i++) {
                    factoriel *= i;
                }
                sum += factoriel; //добавяме факториела на цифрата към общата сума

                // 3. премахваме последната цифра от числото, за да влезе отново в лупа без последна цифра
                number = number / 10;
            }

            System.out.println(sum);
            if (sum == initialNumber) {
                System.out.println("Strong");
            } else {
                System.out.println("Weak");
                return; // прекратява цялата програма!!!!!! спира я!
            }


//        продължаваме с въвеждането на числа в конзолата в главния луп
        number = Integer.parseInt(sc.nextLine());
        }

    }
}
