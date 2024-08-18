package SortingAlgorithms;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {10 , 15 , 20 , 40 , 8 , 11 , 55};
        int low = 0 , mid = 3 , high = 6;
        merge(arr , low , mid , high);
        System.out.println(Arrays.toString(arr));
    }
    public  static void merge(int[] arr , int low , int mid , int high){
        int n1 = mid - low + 1 , n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0 ; i < n1 ;i++){
            left[i] = arr[i + low];
        }
        for(int j = 0 ; j < n2 ; j++) {
            right[j] = arr[mid + 1 + j];
        }
        int i = 0 , j = 0 ,k = low;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }

    }
}
