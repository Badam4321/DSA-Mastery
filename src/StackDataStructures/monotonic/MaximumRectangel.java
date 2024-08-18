package StackDataStructures.monotonic;

import java.util.Stack;

public class MaximumRectangel {
    public static void main(String[] args) {
        int[][] intMatrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        int r = intMatrix.length;
        int c = intMatrix[0].length;
        int max = 0;
        int[][] heights = new int[r][c];
        for(int i = 0 ; i < c ; i++){
            heights[0][i] = intMatrix[0][i];
        }
        for(int i = 1 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(intMatrix[i][j] == 1){
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }
        for(int[] arr : heights){
            max = Math.max(max , largestRectangleArea(arr));
        }
        System.out.println(max);

    }
    static int largestRectangleArea(int[] arr){
        int[] prev = prevSmaller(arr);
        int[] next = nextSmaller(arr);
        int n = arr.length;
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            int width = next[i] - prev[i] - 1;
            int height = arr[i];
            maxArea = Math.max(maxArea , width * height);
        }
        return maxArea;
    }
    static int[] prevSmaller(int[] arr){
        int n = arr.length;
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return prev;
    }
    static int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1 ; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return next;
    }
}
