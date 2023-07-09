import java.util.Arrays;

public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int topRow = 0, bottomRow = n - 1;
        int leftCol = 0, rightCol = n - 1;

        while (num <= n * n) {
            // Fill top row from left to right
            for (int col = leftCol; col <= rightCol; col++) {
                matrix[topRow][col] = num++;
            }
            topRow++;

            // Fill right column from top to bottom
            for (int row = topRow; row <= bottomRow; row++) {
                matrix[row][rightCol] = num++;
            }
            rightCol--;

            // Fill bottom row from right to left
            for (int col = rightCol; col >= leftCol; col--) {
                matrix[bottomRow][col] = num++;
            }
            bottomRow--;

            // Fill left column from bottom to top
            for (int row = bottomRow; row >= topRow; row--) {
                matrix[row][leftCol] = num++;
            }
            leftCol++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);
        // Print the generated matrix
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
