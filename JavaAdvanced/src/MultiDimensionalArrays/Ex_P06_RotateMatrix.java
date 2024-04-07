package MultiDimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_P06_RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split("[()]");

        int degrees = Integer.parseInt(arr[1]);
// 360 90 180 270
//  720 810 900 990
//  1080 1170 1260 1350

        int rotationNum = degrees % 360; //90 % 360 - остава 90, защото не може да се раздели на 360
//        System.out.println(rotationNum);

        char[][] matrix = readMatrix(sc);
//        printMatrix(matrix);


        switch (rotationNum) {
            case 0:
                //do nothing
                printMatrix(matrix);
                break;
            case 90:
                char[][] newM = rotateMatrix(matrix);
                printMatrix(newM);

                break;
            case 180:
                char[][] newMa = rotateMatrix(rotateMatrix(matrix));
                printMatrix(newMa);

                break;
            case 270:
                char[][] newMatr = rotateMatrix(rotateMatrix(rotateMatrix(matrix)));
                printMatrix(newMatr);
                break;
        }
    }

    private static char[][] rotateMatrix(char[][]matrix) {
        int newMatrixRows = matrix[0].length;
        int newMatrixCols = matrix.length;


        char[][] newMatrix = new char[newMatrixRows][newMatrixCols];

        for (int r = 0; r < newMatrixRows; r++) {
            int oldMatrixRow = matrix.length - 1;
            for (int c = 0; c < newMatrixCols; c++) {
                newMatrix[r][c] = matrix[oldMatrixRow][r];
                oldMatrixRow--;
            }
        }
        return newMatrix;
    }

    public static void printMatrix(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner sc) {

        List<String> ls = new ArrayList<>();
        String input = sc.nextLine();

        while (!"END".equals(input)) {
            ls.add(input);
            input = sc.nextLine();
        }

        char[][] matrixFromList = createMatrixFromList(ls);
        return matrixFromList;

    }

    public static char[][] createMatrixFromList(List<String> ls){

        // determine the string with max length and take the length
        int maxStrLength = Integer.MIN_VALUE;
        for (String el : ls) {
            if(el.length() > maxStrLength){
                maxStrLength = el.length();
            }
        }

        char[][] matrix = new char[ls.size()][maxStrLength];
        for (int r = 0; r < matrix.length; r++) {
            String currentStrFromList = ls.get(r);
            for (int c = 0; c < maxStrLength; c++) {
                if(currentStrFromList.length() < maxStrLength && c >= currentStrFromList.length()){
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = currentStrFromList.charAt(c);
                }

            }
        }

        return matrix;
    }
}
