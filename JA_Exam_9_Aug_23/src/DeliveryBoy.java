import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        int[] sizes = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = sizes[0];
        int cols = sizes[1];

        char[][] matrix = new char[rows][cols];

        for(int i = 0; i < rows; i++) {
           matrix[i] = sc.nextLine().toCharArray();
        }

//        printMatrix(matrix);


    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
