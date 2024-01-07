package Ex3_Arrays;

import java.util.Scanner;

public class Task4_ArrayRotation {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        String[] arr = sc.nextLine().split(" ");

        int n = Integer.parseInt(sc.nextLine());

        String temp = "";
        for (int i = 0; i < n; i++) {


                temp = arr[0];


            for (int j = 0; j < arr.length - 1; j++) {

                arr[j] = arr[j + 1];


            }

            arr[arr.length - 1] = temp;


        }


        for (String el : arr) {
            System.out.print(el + " ");
        }

    }
}

