package MoreExc_Methods;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = Integer.parseInt(sc.nextLine());
        int num2 = Integer.parseInt(sc.nextLine());
        int num3 = Integer.parseInt(sc.nextLine());

        printSignOfProduct(num1, num2, num3);


    }

    public static void printSignOfProduct (int a, int b, int c){
        int [] arr = new int[3];
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;

            int countNegative = 0;
            int countPositive = 0;

        for (int i = 0; i < 3; i++) {
            if(arr[i] > 0){
                countPositive++;
            } else if(arr[i] < 0){
                countNegative++;
            }else {
                System.out.println("zero");
                return;
            }
        }

        if((countNegative == 2) && (countPositive == 1)){
            System.out.println("positive");
        }else if((countNegative == 1) && (countPositive == 2)){
            System.out.println("negative");
        }else if(countNegative == 3){
            System.out.println("negative");
        } else if (countPositive == 3){
            System.out.println("positive");
        }


        }
    }

