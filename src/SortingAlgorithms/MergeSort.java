package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 9, 8, 2, 4, 7};
        System.out.println("Before sorting :"+Arrays.toString(arr));
        mergeSort(arr, 0 , arr.length - 1);
        System.out.println("After sorting :"+Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(arr , low , mid);
            mergeSort(arr, mid + 1 , high);
            merge(arr ,low , mid , high);
        }
    }
    public static void merge(int[] arr , int low , int mid , int high){
        //setting up the Auxilary space arrys
        int n1 = mid - low + 1 , n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0 ; i < n1 ; i++) left[i] = arr[i + low];
        for(int j = 0 ; j < n2 ; j++) right[j] = arr[j + mid + 1];

        //standard merge sort algorithms
        int i = 0 , j = 0 , k = low;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else
                arr[k++] = right[j++];
        }

        while(i < n1) arr[k++] = left[i++];
        while(j < n2) arr[k++] = right[j++];
    }

}
