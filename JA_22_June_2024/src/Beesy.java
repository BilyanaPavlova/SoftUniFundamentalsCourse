import java.util.Scanner;

public class Beesy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

        int energy = 15;
        int nectar = 0;
        int goal = 30;
        boolean inHive = false;
        boolean restored = false;

        int[] startB = findPosition(matrix);
        int startRow = startB[0];
        int startCol = startB[1];

        matrix[startRow][startCol] = '-';

        int newRow = startRow;
        int newCol = startCol;

        int previousRow = 0;
        int previousCol = 0;

        String command = sc.nextLine();
        while (true) {

            if (energy < 0) {
                energy = 0;
            }



            if (energy <= 0 && nectar < 30) {
                System.out.println("This is the end! Beesy ran out of energy.");

                break;
            }

            if (energy <= 0 && nectar >= 30 && !restored) {
                energy += nectar - goal;
                nectar = 30;
                restored = true;
            }

            previousRow = newRow;
            previousCol = newCol;

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
            }


//out of bound
            if (newRow < 0) {
                newRow = matrix.length - 1;
            }
            if (newRow > matrix.length - 1){
                newRow = 0;
            }
            if (newCol < 0 ) {
                newCol = matrix.length - 1;
            }
            if(newCol > matrix.length - 1) {
                newCol = 0;
            }

            energy--;

            //flower
            if(Character.isDigit(matrix[newRow][newCol])) {
                int digit = Character.getNumericValue(matrix[newRow][newCol]);
                nectar += digit;
                matrix[newRow][newCol] = '-';
            }

            if (matrix[newRow][newCol] == 'H') {
                if (energy >= 0) {
                    if (nectar >= goal) {
                        System.out.printf("Great job, Beesy! The hive is full. Energy left: %d\n", energy);
                        break;
                    } else {
                        System.out.println("Beesy did not manage to collect enough nectar.");
                        break;
                    }
                }
            }

            command = sc.nextLine();
        }

        matrix[newRow][newCol] = 'B';
        printMatrix(matrix);

    }


    public static int[] findPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'B') {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return position;
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
