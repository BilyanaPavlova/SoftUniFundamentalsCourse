package exam.oct_14_22;

import java.util.Scanner;

public class task03 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int countOfCommands = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row <= size - 1; row++) {
            String line = sc.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();
        }

        int[] position = findPosition(matrix);


        String command = sc.nextLine();
        for (int c = 0; c < countOfCommands; c++ ) {

            //remove the player from the current position and put a dash
            if (matrix[position[0]][position[1]] != 'B' && matrix[position[0]][position[1]] != 'T') {
                matrix[position[0]][position[1]] = '-';
            }



            //calculate the new coordinates
            if (command.equals("up")) {
                position[0] -= 1;
                if(position[0] < 0) {
                    position[0] = size - 1;
                }
            } else if (command.equals("down")) {
                position[0] += 1;
                if(position[0] > size - 1) {
                    position[0] = 0;
                }
            } else if (command.equals("left")) {
                position[1] -= 1;
                if(position[1] < 0) {
                    position[1] = size - 1;
                }
            } else if (command.equals("right")) {
                position[1] += 1;
                if(position[1] > size - 1) {
                    position[1] = 0;
                }
            }

            // check if next position is F and if so break the loop and print the message
            if (matrix[position[0]][position[1]] == 'F') {
                System.out.println("Player won!");
                matrix[position[0]][position[1]] = 'f';
                printM(matrix);
                return;
            }

            //  check if there are no more commands and the player has not reached the 'F' position print the message
            if (c == countOfCommands - 1) {
                System.out.println("Player lost!");
                matrix[position[0]][position[1]] = 'f';
                printM(matrix);
                break;
            }

            if (matrix[position[0]][position[1]] == '-') {
                matrix[position[0]][position[1]] = 'f';
            }

            // check if the new position is equal to 'B' or 'T' and act accordingly
            // if equal to 'B'  move one step forward
            // if equal to 'T' stay on place
            if (matrix[position[0]][position[1]] == 'B') {
                continue;
            }

            if (matrix[position[0]][position[1]] == 'T') {
                if (command.equals("up")) {
                    position[0] += 1;
                } else if (command.equals("down")) {
                    position[0] -= 1;
                } else if (command.equals("left")) {
                    position[1] += 1;
                } else if (command.equals("right")) {
                    position[1] -= 1;
                }

                matrix[position[0]][position[1]] = 'f';
            }



            printM(matrix);

            command = sc.nextLine();



        }





    }

    //method to find the pozition of the player f
    public static int[] findPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'f') {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return position;
    }

    //method to print the matrix
    public static void printM(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
