package linkedList;
import linkedList.Node;
import linkedList.LinkedListCreation;

import java.util.Arrays;

public class SpiralMatrixIv {
    public static void main(String[] args) {
        int[] arr ={3,0,2,6,8,1,7,9,4,2,5,5,0};
        Node head = LinkedListCreation.createLinkedList(arr);
        int rows = 3 , cols = 5;
        int[][] matrix = spiralMatrix(head , rows,cols);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static int[][] spiralMatrix(Node head, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for(int[] arr : matrix){
            Arrays.fill(arr,-1);
        }
        Node curr = head;
        int rowBegin = 0, colBegin = 0;
        int rowEnd = rows - 1, colEnd = cols - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse from left to right along the top row
            for (int i = colBegin; i <= colEnd; i++) {
                if(curr != null){
                    matrix[rowBegin][i] = curr.val;
                    curr = curr.next;
                }
            }
            rowBegin++;

            // Traverse from top to bottom along the rightmost column
            for (int i = rowBegin; i <= rowEnd; i++) {
                if(curr != null){
                    matrix[i][colEnd] = curr.val;
                    curr = curr.next;

                }
            }
            colEnd--;

            // Traverse from right to left along the bottom row
            if (rowBegin <= rowEnd) { // Check if there's still a row to traverse
                for (int i = colEnd; i >= colBegin; i--) {
                    if(curr != null){
                        matrix[rowEnd][i] = curr.val;
                        curr = curr.next;
                    }
                }
            }
            rowEnd--;

            // Traverse from bottom to top along the leftmost column
            if (colBegin <= colEnd) { // Check if there's still a column to traverse
                for (int i = rowEnd; i >= rowBegin; i--) {
                    if(curr != null){
                        matrix[i][colBegin] = curr.val;
                        curr = curr.next;
                    }
                }
            }
            colBegin++;
        }
        return matrix;
    }
}
