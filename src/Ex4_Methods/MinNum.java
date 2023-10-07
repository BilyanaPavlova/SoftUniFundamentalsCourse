package Ex4_Methods;

import java.util.Scanner;

public class MinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());
        int third = Integer.parseInt(sc.nextLine());

        findMin(first,second, third);
    }

    public static void findMin (int a, int b, int c){
        System.out.println(Math.min(Math.min(a,b), c));
    }
}
