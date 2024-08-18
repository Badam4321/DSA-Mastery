package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    static List<Integer> spiralOrder = new ArrayList<>();
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        printSpiralOrder(matrix,matrix.length,matrix[0].length);
        System.out.println(spiralOrder);
    }

    private static void printSpiralOrder(int[][] matrix, int rows, int cols) {


        int rowBegin = 0, colBegin = 0;
        int rowEnd = rows - 1, colEnd = cols - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse from left to right along the top row
            for (int i = colBegin; i <= colEnd; i++) {
                spiralOrder.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse from top to bottom along the rightmost column
            for (int i = rowBegin; i <= rowEnd; i++) {
                spiralOrder.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse from right to left along the bottom row
            if (rowBegin <= rowEnd) { // Check if there's still a row to traverse
                for (int i = colEnd; i >= colBegin; i--) {
                    spiralOrder.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // Traverse from bottom to top along the leftmost column
            if (colBegin <= colEnd) { // Check if there's still a column to traverse
                for (int i = rowEnd; i >= rowBegin; i--) {
                    spiralOrder.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
    }
}
