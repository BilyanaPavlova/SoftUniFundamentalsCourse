import java.util.Arrays;
import java.util.Scanner;

public class task02_Gambler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        //read the matrix
//        for(int i = 0; i < size; i++){
//            char[] row = sc.nextLine().toCharArray();
//            for(int j = 0; j < size; j++) {
//                matrix[i][j] = row[j];
//            }
//        }

        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

//        printMatrix(matrix);

       //current coordinates
        int[] posG = findPosition(matrix);
        int row = posG[0];
        int col = posG[1];

        boolean outOfBoundOrBelow = false;

        int gamblerAmount = 100;


        String com = sc.nextLine();

        //check next coordinates
        while (true) {
                if(com.equals("end")) {
                System.out.printf("End of the game. Total amount: %d$\n", gamblerAmount);
                printMatrix(matrix);
                return;
            }

            int newRow = row;
            int newCol = col;

            switch (com) {
                case "up":
                    newRow = row - 1;

                    break;
                case "down":
                    newRow = row + 1;

                    break;
                case "left":
                    newCol = col - 1;

                    break;
                case "right":
                    newCol = col + 1;

                    break;
            }

            if (newRow < 0 || newRow > size-1 || newCol < 0 || newCol > size - 1) {
                matrix[row][col] = '-';
                System.out.println("Game over! You lost everything!");
                return;
            }

            if (matrix[newRow][newCol] == '-') {
                matrix[row][col] = '-';
                matrix[newRow][newCol] = 'G';
            }

            if (matrix[newRow][newCol] == 'W') {
                matrix[row][col] = '-';
                matrix[newRow][newCol] = 'G';
                gamblerAmount += 100;
            }

            if (matrix[newRow][newCol] == 'P') {
                matrix[row][col] = '-';
                matrix[newRow][newCol] = 'G';
                gamblerAmount -= 200;
                if (gamblerAmount <= 0) {
                    gamblerAmount = 0;
                    System.out.println("Game over! You lost everything!");
                    return;
                }
            }

            if (matrix[newRow][newCol] == 'J') {
                matrix[row][col] = '-';
                matrix[newRow][newCol] = 'G';
                gamblerAmount += 100000;
                System.out.printf("You win the Jackpot!\nEnd of the game. Total amount: %d$\n", gamblerAmount);
                printMatrix(matrix);
                return;
            }

            row = newRow;
            col = newCol;

//            printMatrix(matrix);
            com = sc.nextLine();
        }



    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static int[] findPosition(char[][] matrix){
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 'G') {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }

        }
        return null;
    }


}
