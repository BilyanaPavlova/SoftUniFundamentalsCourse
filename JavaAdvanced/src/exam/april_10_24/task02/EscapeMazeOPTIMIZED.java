package exam.april_10_24.task02;



import java.util.Map;
import java.util.Scanner;

    public class EscapeMazeOPTIMIZED {
        private static final Map<String, int[]> DIRECTIONS = Map.of(
                "up", new int[]{-1, 0},
                "down", new int[]{1, 0},
                "left", new int[]{0, -1},
                "right", new int[]{0, 1}
        );

        private static final int HEALTH_DECREASE = 40;
        private static final int HEALTH_INCREASE = 15;
        private static final int MAX_HEALTH = 100;

        private static final char EMPTY = '-';
        private static final char PLAYER = 'P';
        private static final char MONSTER = 'M';
        private static final char HEAL = 'H';
        private static final char EXIT = 'X';

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int size = Integer.parseInt(sc.nextLine());
            char[][] matrix = readMatrix(sc, size);

            int[] coordinates = findCoordinates(matrix, PLAYER);
            int row = coordinates[0];
            int col = coordinates[1];

            int health = MAX_HEALTH;

            while (true) {
                matrix[row][col] = EMPTY;

                String com = sc.nextLine();
                if (DIRECTIONS.containsKey(com)) {
                    int[] change = DIRECTIONS.get(com);
                    row += change[0];
                    col += change[1];

                    if (row < 0 || row >= matrix.length) {
                        row -= change[0];
                        continue;
                    }

                    if (col < 0 || col >= matrix.length) {
                        col -= change[1];
                        continue;
                    }
                }

                switch (matrix[row][col]) {
                    case MONSTER:
                        health -= HEALTH_DECREASE;
                        if (health <= 0) {
                            health = 0;
                            matrix[row][col] = PLAYER;
                            printResult(matrix, health);
                            return;
                        }
                        break;
                    case HEAL:
                        health += HEALTH_INCREASE;
                        if (health > MAX_HEALTH) {
                            health = MAX_HEALTH;
                        }
                        break;
                    case EXIT:
                        matrix[row][col] = PLAYER;
                        printResult(matrix, health);
                        return;
                }

                matrix[row][col] = PLAYER;

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



