package Lec3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task_4_Reverse_An_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //reading a string array:
        String [] arr = sc.nextLine().split(" ");

        //reversing an array
        String temp;
        int len = arr.length;
        for (int i = 0; i < arr.length/2; i++ ){
           temp = arr[i];
           arr[i] = arr[len-1];
           arr[len-1] = temp;
           len--;

        }

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
