package Lec3_Arrays;

import java.util.Arrays;

public class DataStructBookExample1_delete_remove_reorder {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        int searchKey = 4;
        int nElem = intArray.length;

        for (int i = 0; i < nElem; i++) { // обхожда всички елементи

            if(intArray[i] == searchKey){ // ако намери търсеното
                for (int j = i; j < nElem - 1; j++) { // от неговия индекс нататък премества следващите с една позиция напред
                    intArray[j] = intArray[j+1];
                    nElem--; // намалява размера на масива за следващия цикъл
                            // и по този начин не дублира последния елемент 1,2,3,4,5,5

                }
            }

            System.out.print(intArray[i] + " ");

        }



    }
}
