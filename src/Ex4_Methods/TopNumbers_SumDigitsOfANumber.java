package Ex4_Methods;

import java.util.Scanner;

public class TopNumbers_SumDigitsOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            if (isDivisibleBy8(i) && isOddNumberInside(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isDivisibleBy8(int num) {

        //намиране на сума на цифри на число
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOddNumberInside(int num){
        boolean isOdd = false;
        while (num > 0){
            if ((num % 10)% 2 != 0){
                isOdd = true;
                break;
            }
            num /= 10;
        }
        return isOdd;
    }
}
