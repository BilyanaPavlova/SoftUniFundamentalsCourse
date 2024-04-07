package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinaryConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 0){
            System.out.println(0);
            return;
        }
        ArrayDeque<Integer> stack = binaryConverter(n);
        for (Integer el : stack) {
            System.out.print(el);
        }

    }

    public static ArrayDeque<Integer> binaryConverter(int n){
        ArrayDeque <Integer> stack = new ArrayDeque<>();
        // when dividing by 2 the remainder is always 0 or 1 (binary conversion)
        while(n > 0) {
            int remainder = n % 2;
            stack.push(remainder);
            n /= 2;

        }
        return stack;


    }
}
