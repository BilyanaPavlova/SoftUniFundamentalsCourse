package MultiDimensionalArrays;

import java.util.Scanner;

public class Ex_P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        int cols = rows;
        String pattern = input[1];

        int[][] matrix = new int[rows][cols];

        switch (pattern) {
            case "A":
                int counter = 0;

                for (int r = 0; r < matrix.length; r++) {
                    counter = r + 1;
                    for (int c = 0; c < matrix[r].length; c++) {
                        matrix[r][c] = counter;
                        counter += rows;
                    }
                }

                break;
            case "B":

                counter = 0;

                for (int c = 0; c < cols; c++) {


                    if (c%2 == 0) {

                        for (int r = 0; r < rows; r++) {
                            counter++;
                            matrix[r][c] = counter;
                        }

                        counter = matrix[rows-1][c];
                    } else {

                        for (int r = rows - 1; r >= 0; r--) {
                            matrix[r][c] = counter + 1;
                            counter++;
                        }

                    }


                }

                counter = 0;


                break;
    }

    printMatrix(matrix);


}

    private static void printMatrix(int[][] matrix) {
        for (int[] row: matrix) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}





