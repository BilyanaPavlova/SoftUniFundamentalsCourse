package exam.june_22_24;

import java.util.Scanner;

public class task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        // fill the matrix
        for (int row = 0; row <= matrix.length - 1; row++) {

            String line = sc.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();
        }

        int flowers = 0;

        //find bee position
        int[] pos = findPosition(matrix);

        int initialEnergy = 15;
        boolean isInHive = false;
        boolean isOutOfEnergy = false;
        boolean requiredQuantitycCollected = false; // used when printing result and bee is in the hive
        int collectedNectar = 0;
        boolean rightToRestore = true;


        String com = sc.nextLine();
        while (true) {

            //remove the bee from the current position before changing the position
            matrix[pos[0]][pos[1]] = '-';

            //change the position
            if (com.equals("up")) {
                pos[0] -= 1;
                if (pos[0] < 0) {
                    pos[0] = size - 1;
                }
            } else if (com.equals("down")) {
                pos[0] += 1;
                if (pos[0] > size - 1) {
                    pos[0] = 0;
                }
            } else if (com.equals("left")) {
                pos[1] -= 1;
                if (pos[1] < 0) {
                    pos[1] = size - 1;
                }
            } else if (com.equals("right")) {
                pos[1] += 1;
                if (pos[1] > size - 1) {
                    pos[1] = 0;
                }
            }
            // decrease energy for each move
            initialEnergy--;

            // check if position is a digit
            if (Character.isDigit(matrix[pos[0]][pos[1]])) {
                collectedNectar += Character.getNumericValue(matrix[pos[0]][pos[1]]);
                matrix[pos[0]][pos[1]] = '-';
            }

            //check if the bee is out of energy
            if (initialEnergy <= 0 && rightToRestore && collectedNectar >= 30) {

                int restoreAmount = collectedNectar - 30; // minus the required amount of nectar
                initialEnergy += restoreAmount;
                collectedNectar = 30;

                rightToRestore = false;

            } else if (initialEnergy <= 0 && collectedNectar <= 30 ) {
                    isOutOfEnergy = true;
                    printResult(matrix, isOutOfEnergy, pos, isInHive, initialEnergy, collectedNectar); //
//                    printM(matrix, pos);
                    return;
                }




            if (matrix[pos[0]][pos[1]] == 'H' && collectedNectar >= 30) {
                isInHive = true;
                printResult(matrix, isOutOfEnergy, pos, isInHive, initialEnergy, collectedNectar);
                return;
            }

            if (matrix[pos[0]][pos[1]] == 'H' && collectedNectar < 30) {
                isInHive = true;
                printResult(matrix, isOutOfEnergy, pos, isInHive, initialEnergy, collectedNectar);
                return;
            }

//            printM(matrix, pos); // to remove
            com = sc.nextLine();
        }
    }


        private static void printM ( char[][] matrix, int[] pos){
            matrix[pos[0]][pos[1]] = 'B';
            for (int row = 0; row <= matrix.length - 1; row++) {
                for (int col = 0; col <= matrix[row].length - 1; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }

        public static int[] findPosition (char[][] matrix){
            int[] position = new int[2];
            for (int row = 0; row <= matrix.length - 1; row++) {
                for (int col = 0; col <= matrix[row].length - 1; col++) {
                    if (matrix[row][col] == 'B') {
                        position[0] = row;
                        position[1] = col;
                    }
                }

            }
            return position;
        }

        public static void printResult(char[][] matrix, boolean isOutOfEnergy, int[] pos, boolean isInHive, int initialEnergy, int nectarCollected) {
            if (!isInHive && isOutOfEnergy) {
                System.out.println("This is the end! Beesy ran out of energy.");
                printM(matrix, pos );
            }

            if (isInHive && !isOutOfEnergy && nectarCollected >= 30) {
                System.out.printf("Great job, Beesy! The hive is full. Energy left: %d\n", initialEnergy);
                printM(matrix, pos);
            }

            if (isInHive && !isOutOfEnergy && nectarCollected < 30) {
                System.out.println("Beesy did not manage to collect enough nectar.");
                printM(matrix, pos);
            }
        }

    }

