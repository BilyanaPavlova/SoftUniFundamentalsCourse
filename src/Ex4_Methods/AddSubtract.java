package Ex4_Methods;

import java.util.Scanner;

public class AddSubtract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());


        System.out.println(subtract(add(a,b), c));



    }

    public static int add (int a, int b){
        return a + b;
    }

    public static int subtract (int a, int b){
        return a - b;
    }
}
