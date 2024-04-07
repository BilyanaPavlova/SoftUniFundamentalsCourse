package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = createMatrix(n, sc);
//        printMatrix(matrix);


//        System.out.println(sumPrimaryDiagonal(matrix));
//        System.out.println(sumSecondaryDiagonal(matrix));
        System.out.println(Math.abs(sumPrimaryDiagonal(matrix) - sumSecondaryDiagonal(matrix)));
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = matrix.length-1; i >= 0; i--) {
            sum += matrix[i][matrix.length-1 - i];
        }

        return sum;
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;

        for (int r = 0; r < matrix.length; r++) {

                sum += matrix[r][r];

        }
        return sum;
    }

    public static int[][] createMatrix(int n, Scanner sc){
        int[][] matrix = new int[n][n];

        for (int r = 0; r < n; r++) {
            matrix[r] = readArray(sc);
        }
        return matrix;
    }

    private static int[] readArray(Scanner sc) {
        int[]arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arr;
    }

    public static void printMatrix(int[][] matrix){

        for (int r = 0; r < matrix.length; r++) {
            for (int col = 0; col < matrix[r].length; col++) {
                System.out.print(matrix[r][col]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}
