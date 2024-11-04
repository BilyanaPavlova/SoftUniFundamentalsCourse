package exam.oct_17_22.task02_BEE_EXAM_MATRIX_TO_SEE;

import java.util.Arrays;
import java.util.Scanner;

public class task02_BEE_MATRIX_EXAM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row <= matrix.length - 1; row ++) {

            String line = sc.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();

        }

        int flowers = 0;

        //coordinates row and col:
        int[] position = findPosition(matrix);
        int beeRow = position[0];
        int beeCol = position[1];

        String com = sc.nextLine();
        while(true) {
            if (com.equals("End")) {
                printResults(flowers);
                printM(matrix);
                return;
            }

            //преди да променя координатите махам пчелата от текушите координати и слагам точка
            matrix[beeRow][beeCol] = '.';

            //променям координатите
           if (com.equals("left")) {
               beeCol--;
           } else if (com.equals("right")) {
               beeCol++;
           } else if (com.equals("up")) {
               beeRow--;
           } else if (com.equals("down")) {
               beeRow++;
           }

            if (beeRow < 0 || beeRow > size - 1 || beeCol < 0 || beeCol > size - 1) {
                System.out.println("The bee get lost!");
                printResults(flowers);
                printM(matrix);
                return;
            }

            //проверка какво има на новите координати
            if (matrix[beeRow][beeCol] == 'O') {
                continue; //прескача долните редове на лупа и влиза пак в него. изпълнява същата команда, на която е останало com.
            }
            if (matrix[beeRow][beeCol] == 'f') {
                flowers++;
            }





           //слагам пчелата на новите координати
            matrix[beeRow][beeCol] = 'B';

            //сканирам новата команда
            com = sc.nextLine();
        }

    }

    public static int[] findPosition(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }



    public static void printM(char[][] matrix) {

        for (int row = 0; row <= matrix.length - 1; row ++) {
            System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[\\]\\s+,]", ""));
        }
    }

    public static void printResults(int flowers) {
        if (flowers < 5) {
            int needed = 5 - flowers;
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", needed);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", flowers);
        }

    }







}

