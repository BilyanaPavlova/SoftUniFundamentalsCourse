package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Ex_P04_MaximalSUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(rows, cols, sc);
//        printMatrix(matrix);

        int lastStartingIdxCol = cols - 3;
        int lastStartingIdxRow = rows - 3;

        int[][] subMatrix = new int [3][3];
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[3][3];

        for (int i = 0; i <= lastStartingIdxRow; i++) {
            int currentI = i;
            for (int j = 0; j <= lastStartingIdxCol; j++) {

                int currentJ = j;
                for (int k = 0; k < subMatrix.length; k++) {
                    //fill the row of the submatrix
                    for (int l = 0; l < subMatrix[k].length; l++) {
                        subMatrix[k][l] = matrix[i][j];
                        //increase the matrix column with 1
                        j++;
                    }
                    //when the row of the submatrix is filled,
                    // put the submatrix column to be equal to the starting point in the big matrix column
                    j = currentJ;

                    //take the next row in the big matrix
                    i++;

                }
                //when the starting points in the matrix first row are over
                //make the row start again from the loop order
                i = currentI;

//                printMatrix(subMatrix);
//                System.out.println();
                int sum = sumMatrix(subMatrix);
                if(sum > maxSum){
                    maxSum = sum;

                    //copy the submatrix to the maxMatrix
                    for (int m = 0; m < maxMatrix.length ; m++) {
                        for (int n = 0; n < maxMatrix[m].length; n++) {
                            maxMatrix[m][n] = subMatrix[m][n];
                        }
                    }
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrix(maxMatrix);






    }

    public static int sumMatrix (int[][]matrix){
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }

    public static int[][] readMatrix(int rows, int cols, Scanner sc){
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = arr[c];
            }
        }
        return matrix;
    }


        public static void printMatrix(int[][]matrix){
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }
        }

}
