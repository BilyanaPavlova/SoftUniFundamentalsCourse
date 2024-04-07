package MultiDimensionalArrays.problems;

public class Fill_By_Columns {

    public static void main(String[] args) {
        int rows = 6;
        int cols = 6;

        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[c][r] = counter; //fill by columns (replace the r with c)
                counter++;
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
