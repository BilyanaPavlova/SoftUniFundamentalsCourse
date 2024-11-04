import java.util.Scanner;

public class fishingArea_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

        int totalFishCatch = 0;
        boolean quotaReached = false;
        int[] coordS = findS(matrix);
        matrix[coordS[0]][coordS[1]] = '-';

        String com = sc.nextLine();
        while (true) {
            matrix[coordS[0]][coordS[1]] = '-';

            if (com.equals("collect the nets")) {
                matrix[coordS[0]][coordS[1]] = 'S';
                if (totalFishCatch < 20) {
                    System.out.printf("You didn't catch enough fish and didn't reach the quota! " +
                            "You need %d tons of fish more.\n", 20 - totalFishCatch);
                }
                if (totalFishCatch > 0) {
                    System.out.printf("Amount of fish caught: %d tons.\n", totalFishCatch);
                }
                printMatrix(matrix);
                return;
            }

            switch (com) {
                case "up":
                    coordS[0] = (coordS[0] - 1 + size) % size;
                    break;
                case "down":
                    coordS[0] = (coordS[0] + 1) % size;
                    break;
                case "left":
                    coordS[1] = (coordS[1] - 1 + size) % size;
                    break;
                case "right":
                    coordS[1] = (coordS[1] + 1) % size;
                    break;
            }

            char newCoord = matrix[coordS[0]][coordS[1]];
            if (isDigit(newCoord)) {
                int fishCatch = charToDigit(newCoord);
                totalFishCatch += fishCatch;
                if (totalFishCatch >= 20 && !quotaReached) {
                    System.out.println("Success! You managed to reach the quota!");
                    quotaReached = true;
                }
                matrix[coordS[0]][coordS[1]] = 'S';
            }

            if (newCoord == 'W') {
                System.out.printf("You fell into a whirlpool! " +
                        "The ship sank and you lost the fish you caught. " +
                        "Last coordinates of the ship: [%d,%d]\n", coordS[0], coordS[1]);
                return;
            }
            com = sc.nextLine();
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static int[] findS(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null; // 'S' not found
    }

    public static int charToDigit(char c) {
        return Character.getNumericValue(c);
    }

    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}