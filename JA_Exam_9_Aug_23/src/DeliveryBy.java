import javax.swing.text.StyleContext;
import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = numbers[0];
        int cols = numbers[1];

        // Initialize the matrix
        char[][] matrix = new char[rows][cols];

        // Read each row of the matrix
        for (int i = 0; i < rows; i++) {
            char[] rowInput = sc.nextLine().toCharArray();
            matrix[i] = rowInput;
        }

        int[] startB = findPosition(matrix);
        int rowB = startB[0];
        int colB = startB[1];

        matrix[rowB][colB] = '.';
        int newRow = rowB;
        int newCol = colB;
        boolean out = false;

        while (true) {
            String command = sc.nextLine();
            int previousRow = newRow;
            int previousCol = newCol;
            switch (command) {
                case "up":
                    newRow = newRow - 1;
                    break;
                case "down":
                    newRow = newRow + 1;
                    break;
                case "left":
                    newCol = newCol - 1;
                    break;
                case "right":
                    newCol = newCol + 1;
                    break;
            }

            if (newRow < 0 || newRow > rows - 1 || newCol < 0 || newCol > cols - 1) {
                out = true;
                System.out.println("The delivery is late. Order is canceled.");
                printMatrix(matrix, out, startB);
                return;
            }

            if (matrix[newRow][newCol] == '-' || matrix[newRow][newCol] == '.') {
                matrix[newRow][newCol] = '.';
//                printMatrix(matrix, out, startB);
            }


            if (matrix[newRow][newCol] == 'P') {
                matrix[newRow][newCol] = 'R';
                System.out.println("Pizza is collected. 10 minutes for delivery.");
//                printMatrix(matrix, out, startB);
            }


            if (matrix[newRow][newCol] == '*') {
                newRow = previousRow;
                newCol = previousCol;
//                printMatrix(matrix, out, startB);
                continue;
            }


            if (matrix[newRow][newCol] == 'A') {
                ;
                matrix[newRow][newCol] = 'P';
                System.out.println("Pizza is delivered on time! Next order...");
                printMatrix(matrix, out, startB);
                return;
            }





        }
    }


    public static void printMatrix(char[][] matrix, boolean out, int[] startB) {

        if (out) {
            matrix[startB[0]][startB[1]] = ' ';
        } else {
            matrix[startB[0]][startB[1]] = 'B';
        }

        // Print the matrix to verify
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static int[] findPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }

        }
        return position;
    }
}



