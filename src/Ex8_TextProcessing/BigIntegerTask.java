package Ex8_TextProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger bi = sc.nextBigInteger();
        sc.nextLine();
        byte b = Byte.parseByte(sc.nextLine());

        System.out.println(bi.multiply(BigInteger.valueOf(b)));
    }

}
