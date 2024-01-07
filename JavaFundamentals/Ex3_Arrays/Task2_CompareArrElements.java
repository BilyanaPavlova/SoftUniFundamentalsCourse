package Ex3_Arrays;

import java.util.Scanner;

public class Task2_CompareArrElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] firstArr = sc.nextLine().split(" ");
        String [] secondArr = sc.nextLine().split(" ");


        for (int i = 0; i < firstArr.length; i++){
            for(int j = 0; j< secondArr.length; j++){
                if(secondArr[j].equals(firstArr[i])){
                    System.out.println(secondArr[j]);
                }
            }
        }

//        for (String el2: secondArr){
//            for (String el1:firstArr) {
//                if (el2.equals(el1)){
//                    System.out.print(el2 + " ");
//                }
//            }
//        }
    }
}
