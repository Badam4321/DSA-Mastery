package backtracking;

import java.util.ArrayList;
import java.util.List;



public class Permutations {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr,result,0);
        System.out.println(result);
    }

    private static void backtrack(int[] arr, List<List<Integer>> result, int index) {
        if(index == arr.length - 1){
            List<Integer> temp = new ArrayList<>();
            for(Integer item : arr){
                temp.add(item);
            }
            result.add(temp);
            return;
        }
        for (int i = index ; i < arr.length ; i++){
            swap(arr,i,index);
            backtrack(arr,result,index + 1);
            swap(arr,i,index);
        }

    }

    private static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
