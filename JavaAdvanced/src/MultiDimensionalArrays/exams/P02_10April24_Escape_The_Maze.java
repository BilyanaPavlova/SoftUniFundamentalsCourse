package MultiDimensionalArrays.exams;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;


public class P02_10April24_Escape_The_Maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = rows;

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().toCharArray();

        }

//        printMatrix(matrix);

        int[] coordinatesP = findCharacterInMatrix(matrix, 'P');

//        System.out.println(Arrays.toString(coordinatesP));

        BiPredicate<int[], char[][]> isMonster = (coord, mat) -> mat[coord[0]][coord[1]] == 'M';
        BiPredicate<int[], char[][]> isHealth = (coord, mat) -> mat[coord[0]][coord[1]] == 'H';
        BiPredicate<int[], char[][]> isFree = (coord, mat) -> mat[coord[0]][coord[1]] == '-';
        BiPredicate<int[], char[][]> isX = (coord, mat) -> mat[coord[0]][coord[1]] == 'X';


        int health = 100;

        Direction direction;

        while (sc.hasNext()) {
            String input = sc.next();
            direction = Direction.valueOf(input.toUpperCase());

            int[] checkNewCoordinates = move(matrix, coordinatesP, direction);

            if (isMonster.test(checkNewCoordinates, matrix)) {
                health -= 40;
                if (health <= 0) {
                    health = 0;
                    //M does not disappear
                    updateMatrix(matrix, coordinatesP, '-');
                    coordinatesP = updateMatrix(matrix, checkNewCoordinates, 'P');

                    finalPrint(matrix, health);
                    return;
                }
                //M disappears
                updateMatrix(matrix, coordinatesP, '-');
                coordinatesP = updateMatrix(matrix, checkNewCoordinates, 'P');

//                        printMatrix(matrix);


            }

            if (isHealth.test(checkNewCoordinates, matrix)) {
                health += 15;
                if (health > 100) {
                    health = 100;
                }

                updateMatrix(matrix, coordinatesP, '-');
                coordinatesP = updateMatrix(matrix, checkNewCoordinates, 'P');

//                        printMatrix(matrix);

            }

            if (isFree.test(checkNewCoordinates, matrix)) {

                updateMatrix(matrix, coordinatesP, '-');

                coordinatesP = updateMatrix(matrix, checkNewCoordinates, 'P');

//                        printMatrix(matrix);

            }

            if (isX.test(checkNewCoordinates, matrix)) {

                updateMatrix(matrix, coordinatesP, '-');

                coordinatesP = updateMatrix(matrix, checkNewCoordinates, 'P');

                finalPrint(matrix, health);
            }

        }


    }


//    -------------------------

        // Define directions using an enum
        public enum Direction {
            UP, DOWN, LEFT, RIGHT
        }

        // Method to move in the given direction and return new coordinates
        public static int[] move ( char[][] matrix, int[] coordinatesP, Direction direction){
            int newRow = coordinatesP[0];
            int newCol = coordinatesP[1];

            switch (direction) {
                case UP:
                    newRow = coordinatesP[0] - 1;
                    break;
                case DOWN:
                    newRow = coordinatesP[0] + 1;
                    break;
                case LEFT:
                    newCol = coordinatesP[1] - 1;
                    break;
                case RIGHT:
                    newCol = coordinatesP[1] + 1;
                    break;
            }

            // Check if the new coordinates are within the matrix bounds
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length) {
                return new int[]{newRow, newCol};
            } else {
                // Return the original coordinates if the move is out of bounds
                return new int[]{coordinatesP[0], coordinatesP[1]};
            }

        }


        public static int[] updateMatrix ( char[][] mat, int[] coords, char a){
            // Update the matrix at the given coordinates
            if (coords[0] >= 0) { // Ensure we are not out of bounds
                mat[coords[0]][coords[1]] = a;
            }
            // Find the new coordinates of 'P'
            return findCharacterInMatrix(mat, 'P');
        }


//    ---------------------------

        public static int[] findCharacterInMatrix ( char[][] matrix, char target){
            // Iterate through each cell of the matrix
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    // Compare each cell with the target string
                    if (matrix[i][j] == (target)) {
                        // Return the coordinates (row and column) as an array
                        return new int[]{i, j};
                    }
                }
            }
            // Return null if the string is not found
            return null;
        }

        public static void printMatrix ( char[][] matrix){
//        System.out.println("The filled matrix is:");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }

        }

        public static void finalPrint ( char[][] matrix, int health){
            if (health > 0) {
                System.out.println("Player escaped the maze. Danger passed!");
            } else {
                System.out.println("Player is dead. Maze over!");
            }
            System.out.printf("Player's health: %s units\n", health);
            printMatrix(matrix);
        }

}
