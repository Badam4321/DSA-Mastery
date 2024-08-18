package SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        System.out.println("Before sorting the array "+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After sorting the array "+ Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped ;
        for(int i = 0 ; i < n - 1 ; i++){
            swapped = false;
            for(int j = 0 ; j < n - i - 1 ; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
    }
}
/*
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.
This algorithm is not suitable for large data sets as its average and worst case time complexity is quite high.
Consider an array arr[] = {5, 1, 4, 2, 8}

First Pass(i == 0):
Bubble sort starts with very first two elements, comparing them to check which one is greater.
( 5 1 4 2 8 ) --> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 5 4 2 8 ) -->  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) -->  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
Second Pass(i == 1):
Now, during second iteration it should look like this:
( 1 4 2 5 8 ) --> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) --> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) -->  ( 1 2 4 5 8 )
Third Pass(i == 2):
Now, the array is already sorted, but our algorithm does not know if it is completed.
we can break the loop no need to further iterations array is sorted itself.
Fourth Pass(i == 3)
The algorithm needs one whole pass without any swap to know it is sorted.
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )

time Complexity : O(n^2)
space Complexity : O(1)
 */

