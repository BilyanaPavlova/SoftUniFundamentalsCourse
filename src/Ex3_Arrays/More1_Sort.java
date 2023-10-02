package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class More1_Sort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numStrings = Integer.parseInt(sc.nextLine());

        String[] strings = new String[numStrings];
        int sum = 0;

        int[] stringNumbers = new int[numStrings];
        int tempSort = 0;

        // filling an array with strings
        for (int i = 0; i < numStrings; i++) {
            strings[i] = sc.nextLine();
        }

        // за всеки стринг в масива
        for (int j = 0; j < numStrings; j++) {
            char[] charArray = strings[j].toCharArray();

            // за всички букви от всеки отделен стринг
            // изчислява сума за всеки отделен стринг
            for (int k = 0; k < charArray.length; k++) {
                switch (charArray[k]) {
                    case 'a':
                    case 'o':
                    case 'e':
//                    case 'y':
                    case 'i':
                    case 'u': {
                        sum += (charArray[k] * charArray.length);
                    }
                    break;
                    default: {
                        sum += (charArray[k] / charArray.length);
                    }
                    break;
                }
            }


            stringNumbers[j] = sum;
            sum = 0;

        }

// SORTING AN ARRAY

        boolean swapped = true;
        int n = stringNumbers.length;

        while (swapped) {
            swapped = false;
            for (int m = 0; m < n - 1; m++) {
                if (stringNumbers[m] > stringNumbers[m + 1]) {
                    tempSort = stringNumbers[m];
                    stringNumbers[m] = stringNumbers[m + 1];
                    stringNumbers[m + 1] = tempSort;
                    swapped = true;
                }
            }
            n--;
        }

//        bubbleSort(stringNumbers);


        //print the numbers
        for (int g = 0; g < stringNumbers.length; g++) {
            System.out.println(stringNumbers[g]);
        }

    }


    // BUBBLE SORT METHOD
//    public static void bubbleSort(int[] arr) {
//        int n = arr.length;
//        boolean swapped;
//        do {
//            swapped = false;
//            for (int i = 1; i < n; i++) {
//                if (arr[i - 1] > arr[i]) {
//                    // Swap arr[i-1] and arr[i]
//                    int temp = arr[i - 1];
//                    arr[i - 1] = arr[i];
//                    arr[i] = temp;
//                    swapped = true;
//                }
//            }
//            n--; // Reduce the size of the unsorted portion
//        } while (swapped);
//    }


}



