package exam.oct_22_22.task02;

import java.util.*;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        String num = sc.nextLine();

        String[][] matrix = new String[size][size];

        //read matrix
        for (int row = 0; row < size; row++) {
            String[] line = sc.nextLine().split("\\s+");
            matrix[row] = line;
        }

        //find the T
        List<Integer> coordinatesOfTunnel = findT(matrix);

        int km = 0;

        int carRow = 0;
        int carCol = 0;

        String com = sc.nextLine();
        // чета командите
        while (true) {
            //move the car in the matrix

            //преди да променя координатите махам the car от текушите координати и слагам точка
            matrix[carRow][carCol] = ".";

            //променям координатите
            if (com.equals("End")) {
                matrix[carRow][carCol] = "C";
                System.out.println("Racing car " + num + " DNF.");
                System.out.println("Distance covered " + km + " km.");
                printMatrix(matrix);
                return;

            } else if (com.equals("left")) {
                carCol--;
            } else if (com.equals("right")) {
                carCol++;
            } else if (com.equals("up")) {
                carRow--;
            } else if (com.equals("down")) {
                carRow++;
            }

            //проверка какво има на новите координати
            if (matrix[carRow][carCol].equals("T")) {
                km += 30;
                matrix[carRow][carCol] = ".";
                matrix[coordinatesOfTunnel.get(2)][coordinatesOfTunnel.get(3)] = ".";
                carRow = coordinatesOfTunnel.get(2);
                carCol = coordinatesOfTunnel.get(3);
            }else if (matrix[carRow][carCol].equals(".")) {
                km += 10;
                matrix[carRow][carCol] = "C";
            }else if (matrix[carRow][carCol].equals("F")) {
                km += 10;
                matrix[carRow][carCol] = "C";
                System.out.println("Racing car " + num + " finished the stage!");
                System.out.println("Distance covered " + km + " km.");
                printMatrix(matrix);

                return;
            }
//            printMatrix(matrix);

            com = sc.nextLine();
        }

    }





//find the T
    public static List<Integer> findT (String[][] matrix) {
        List<Integer> coordinates = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("T")) {
                    coordinates.add(row);
                    coordinates.add(col);
                }
            }

        }
        return coordinates;
    }

    public static void printMatrix (String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]).replaceAll("[\\[\\],\\s+]", ""));
        }
    }


}
