package SortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveElementToCorrectPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2};
        // Already sorted part is [1, 3, 4, 5], we need to move '2'
        moveElement(arr, 4);
        System.out.println(Arrays.toString(arr));

    }

    private static void moveElement(int[] arr, int currentIndex) {
        int currentValue = arr[currentIndex];
        int i = currentIndex - 1;
        while(i >= 0 && arr[i] > currentValue){
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = currentValue;
    }
}
