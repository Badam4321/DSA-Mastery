package SortingAlgorithms;

import java.util.Arrays;

public class MoveMinToFirst {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 9, 8, 2, 4, 7};
        moveMinToFirst(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveMinToFirst(int[] arr) {
        int minIndex = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] < arr[minIndex])
                minIndex = i;
        }
        int temp = arr[0];
        arr[0] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
