package SortingAlgorithms;

import java.util.Arrays;

public class QuickSortUsingLomutoPartition {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 1, 2, 4, 5, 6 };
        System.out.println(" Before sorting the nums: " + Arrays.toString(nums));
        quickSort(nums , 0 , nums.length - 1);
        System.out.println("After sorting the nums : " + Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int low, int high) {
        if(low < high){
            int pivotIndex = lomutoPartition(nums , low , high);
            quickSort(nums , low , pivotIndex - 1);
            quickSort(nums , pivotIndex + 1 , high);
        }
    }

    private static int lomutoPartition(int[] nums, int low, int high) {
        int i = low - 1;
        int pivot = nums[high];
        for(int j = low ; j < high ; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums , i , j);
            }
        }
        i++;
        swap(nums , i , high);
        return  i;

    }
    private static void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
