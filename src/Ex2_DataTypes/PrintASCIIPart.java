package Ex2_DataTypes;

import java.util.Scanner;

public class PrintASCIIPart {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());

        for (int i = start; i <= end; i++) {
            System.out.print((char) i + " ");
        }
    }

}
