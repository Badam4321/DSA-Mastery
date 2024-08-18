package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Before sorting : " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After sorting : " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for(int i = 1 ; i < arr.length ; i++){
            moveElementToCorrectPosition(arr , i);
        }
    }

    private static void moveElementToCorrectPosition(int[] arr, int currentIndex) {
        int currentValue = arr[currentIndex];
        int i = currentIndex - 1;
        while(i >= 0 && arr[i] > currentValue){
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = currentValue;

    }
}
