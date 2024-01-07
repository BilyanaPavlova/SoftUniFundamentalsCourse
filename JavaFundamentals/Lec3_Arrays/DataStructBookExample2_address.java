package Lec3_Arrays;

import java.util.Arrays;

public class DataStructBookExample2_address {

    public static void main(String[] args) {
        int[] intArray = new int[5];
        int [] secondIntArray = new int[6];

        intArray = secondIntArray; //assign the address of secondIntArray to the first intArray.
                                    // now the first intArray will hold the address to the second one
                                    //and the first array will be lost and collected by garbage collector

        for (int i = 1; i <= 5; i++) {
            intArray[i] = i;
            System.out.print(intArray[i] + " " );
        }
        System.out.println();

        for (int j = 0; j < 6; j++) {
            secondIntArray[j] = j+7;
            System.out.print(secondIntArray[j] + " ");
        }

        System.out.println();

        intArray = secondIntArray; // assign the second address to the first address variable.
                                    // now the first variable holds the second variable address
                                    // that point to the second array

        System.out.println(Arrays.toString(intArray)
                .replace("[", "")
                .replace("]", ""));


        // initialization

        int[] arr = {1, 2,3, 4, 5}; // the size of the array is determined from the number of element
        int[] arr1 = new int[5]; // all elements are initialised with their default value (for int it's 0)
        String[] arr2 = new String[5];
        System.out.println(arr1[1]); // 0
        System.out.println(arr2[1]); // null




    }
}
