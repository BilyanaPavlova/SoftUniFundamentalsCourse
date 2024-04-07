package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = readMatrix(rows, cols, sc);

        String command = sc.nextLine();
        while(!command.contains("END")){
            String[] com = command.split("\\s+");

            try{
                int rowFirstEl = Integer.parseInt(com[1]);
                int colFirstEl = Integer.parseInt(com[2]);
                int rowSecondEl = Integer.parseInt(com[3]);
                int colSecondEl = Integer.parseInt(com[4]);

                if("swap".equals(com[0]) && com.length == 5) {
                    String[][] newMatrix = swapMatrix(rowFirstEl, colFirstEl, rowSecondEl, colSecondEl, matrix);
                    printMatrix(newMatrix);
                } else {
                    System.out.println("Invalid input!");
                }

            }catch (Exception e){
                System.out.println("Invalid input!");
            }

            command = sc.nextLine();
        }
    }

    public static String[][] swapMatrix(int rowFirstEl, int colFirstEl, int rowSecondEl, int colSecondEl, String[][] matrix){
        String temp = null;
        temp = matrix[rowFirstEl][colFirstEl];
        matrix[rowFirstEl][colFirstEl] = matrix[rowSecondEl][colSecondEl];
        matrix[rowSecondEl][colSecondEl] = temp;
        return matrix;
    }

    public static String[][] readMatrix(int rows, int cols, Scanner sc){
        String[][] matrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = sc.nextLine().split("\\s+");
        }
        return matrix;
    }

    public static void printMatrix(String[][]matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
