package exam.april_10_24.task02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EscapeMaze_EXAM_SEE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        char[][] matrix = readMatrix(sc, size);

//        printMatrix(matrix);

//       Arrays.stream(findCoordinates(matrix, 'H')).forEach(System.out::println);

        // find initial coordinates of P
        int [] coordinates = findCoordinates(matrix, 'P');
        int row = coordinates[0];
        int col = coordinates[1];

        int health = 100;

        //OPTIMIZED WITHOUT REPEATING
        Map<String, int[]> directions = new HashMap<>();
        directions.put("up", new int[]{-1, 0});
        directions.put("down", new int[]{1, 0});
        directions.put("left", new int[]{0, -1});
        directions.put("right", new int[]{0, 1});

        String com = sc.nextLine();
        while (true) {

            // remove the P from its current position
            matrix[row][col] = '-';

            //change coordinates
            if (directions.containsKey(com)) {
                int[] change = directions.get(com);
                row += change[0];
                col += change[1];

                if (row < 0 || row >= matrix.length) {
                    row -= change[0];
                    com = sc.nextLine();
                    continue;
                }

                if (col < 0 || col >= matrix.length) {
                    col -= change[1];
                    com = sc.nextLine();
                    continue;
                }
            }




            //check the position
            if (matrix[row][col] == 'M') {
                health -= 40;
                if (health > 0) {
                } else {
                    health = 0;
                    matrix[row][col] = 'P';
                    printResult(matrix, health);
                    return;

                }
            }

            if (matrix[row][col] == 'H') {
                health += 15;
                if (health > 100) {
                    health = 100;
                }
             }

            if (matrix[row][col] == 'X') {
                printResult(matrix, health);
                return;
            }

            matrix[row][col] = 'P';

            printMatrix(matrix);
            com = sc.nextLine();
        }



    }

    public static char[][] readMatrix (Scanner sc, int size) {
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        return matrix;
    }

    public static void printResult(char[][] matrix, int health) {
        if (health <= 0)  {
            System.out.println("Player is dead. Maze over!");
        } else {
            System.out.println("Player escaped the maze. Danger passed!");
        }

        System.out.printf("Player's health: %d units\n", health);

        printMatrix(matrix);
    }

    public static void printMatrix (char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }
    }

    public static int[] findCoordinates(char[][] matrix, char searchedChar) {

        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[row][col] == searchedChar) {
                    coordinates[0] = row;
                    coordinates[1]= col;
                    return coordinates;
                }

            }
        }
        return coordinates;
    }
}
