package Ex4_Methods;

import java.util.Scanner;

public class PrintMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        printMatrix(a);


    }

    public static void printMatrix(int a){
        for (int i = 0; i < a; i++) { // for each row
            for (int j = 0; j < a; j++) { //for each column
                System.out.print(a + " ");
            }
            System.out.println();


        }
    }
}
