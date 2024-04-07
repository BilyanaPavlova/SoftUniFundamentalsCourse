package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_P02_MatixOfPalindromes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = readArray(sc);
        int rows = array[0];
        int cols = array[1];
        int arrs = 3;

        String[][][] matrix = createMatrix(rows, cols, arrs);

        printMatrix(matrix);
        }

    private static String[][][] createMatrix(int rows, int cols, int arrs) {
        String[][][] matrix = new String[rows][cols][arrs];

        String firstLetter = "a";
        String middleLetter = "a";
        String startingMiddleLetter = "a";

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                for (int i = 0; i < arrs; i++) {
                    //попълва трите букви на всяко масивче в масива от масива
                    matrix[r][c][i] = firstLetter + middleLetter + firstLetter;
                    }

                //променя средната буква, когато свърши попълването на елемент от колоната
                middleLetter = new String(new char[]{(char) (middleLetter.charAt(0)+1)});

            }

            //променя буквите, когато свърши попълването на реда(масива с масивите)
            firstLetter = new String(new char[]{(char) (firstLetter.charAt(0)+1)});
            middleLetter = new String(new char[]{(char) (startingMiddleLetter.charAt(0)+ 1 + r)});


            }
        return matrix;
    }

    private static int[] readArray(Scanner sc) {
        int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return array;
    }

    private static void printMatrix(String[][][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                for (int i = 0; i < matrix[r][c].length; i++) {
                    System.out.print(matrix[r][c][i].charAt(i));

                }
                System.out.print(" ");

            }
            System.out.println();
        }
    }


}

