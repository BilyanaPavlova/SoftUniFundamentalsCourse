package exam.febr_17_24.task02;

import java.util.Scanner;

public class JetFighter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextLine().toCharArray();
            }

//        printMatrix(matrix);

        int jetArmor = 300;

        int[] currentPos = findJet(matrix);

//        for (int i = 0; i < jetCoordinates.length; i++) {
//            System.out.println(jetCoordinates[i]);
//        }

        int shotPlanes = 0;

        // calculate new positions in the matrix

        String direction = sc.nextLine();

        while (true) {

        int [] newPos = findJet(matrix);

        //remove from currentPos
            matrix[newPos[0]][newPos[1]] = '-';

        switch (direction) {
            case "up":
                if (newPos[0] > 0) {
                    newPos[0]--;
                }
                break;
            case "down":
                if (newPos[0] < matrix.length - 1) {
                    newPos[0]++;
                }
                break;
            case "left":
                if (newPos[1] > 0) {
                    newPos[1]--;
                }
                break;
            case "right":
                if (newPos[1] < matrix[0].length - 1) {
                    newPos[1]++;
                }
                break;
        }

        //check the new position
            if (matrix[newPos[0]][newPos[1]] == '-') {
                matrix[newPos[0]][newPos[1]] = 'J';
            }

            if (matrix[newPos[0]][newPos[1]] == 'E') {

                matrix[newPos[0]][newPos[1]] = 'J';

                if(jetArmor == 100) {

                    System.out.printf("Mission failed, your jetfighter was shot down! " +
                            "Last coordinates [%d, %d]!\n", newPos[0], newPos[1]);
                    printMatrix(matrix);
                    return;
                }

                if (shotPlanes != 3) {
                    jetArmor -= 100;
                }
                shotPlanes++;

                if (shotPlanes == 4) {
                    System.out.println("Mission accomplished, you neutralized the aerial threat!");
                    printMatrix(matrix);
                    return;
                }

            }

            if (matrix[newPos[0]][newPos[1]] == 'R') {

                matrix[newPos[0]][newPos[1]] = 'J';
                jetArmor = 300;

            }



        direction = sc.nextLine();
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

    public static int[] findJet (char[][] matrix) {
        int[] coord = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'J') {
                    coord[0] = i;
                    coord[1] = j;
                    break;
                }
            }
        }
        return coord;
    }
}




