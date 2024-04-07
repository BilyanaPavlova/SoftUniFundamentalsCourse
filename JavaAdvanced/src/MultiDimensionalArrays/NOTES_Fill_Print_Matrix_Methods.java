package MultiDimensionalArrays;

import java.util.Scanner;

public class NOTES_Fill_Print_Matrix_Methods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = 5;
        int cols = 5;
        int[][] rowsMatrix = fillMatrixByRows(rows, cols);

        int[][] colsMatrix = fillMatrixByCols(rows, cols);

        printMatrix(rowsMatrix);

        System.out.println();

        printMatrix(colsMatrix);

    }

    private static void printMatrix(int [][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixByRows(int rows, int cols) {
        int [][] matrix = new int[rows][cols];

        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixByCols(int rows, int cols) {
        int [][] matrix = new int[rows][cols];

        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                matrix[col][row] = counter; // replaced row with col
                counter++;
            }
        }
        return matrix;
    }
}
