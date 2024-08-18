package dynamicProgramming.SubsequencePattern;

import java.util.Arrays;



public class SubsetSumEqualsK {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int target = 4;
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        boolean ans = subSetSum(n - 1, target, dp, arr);
        System.out.println(ans);
        boolean res = tabulation(arr,target);
        System.out.println(res);
    }

    private static boolean tabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];
        for(int i = 0 ; i < n ; i ++){
            dp[i][0] = true;
        }
        if(arr[0] <= target){
            dp[0][arr[0]]= true;
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j <= target ; j++ ){
                boolean notTaken = dp[i-1][j];
                boolean take = false;
                if(j >= arr[i]){
                    take = dp[i -1][j - arr[i]];
                }
                dp[i][j] = take || notTaken;
            }
        }
        return dp[n - 1][target];
    }

    private static boolean subSetSum(int index, int target, int[][] dp, int[] arr) {
        if (target == 0)
            return true;
        if (index == 0) {
            return arr[index] == target;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }
        boolean notTaken = subSetSum(index - 1, target, dp, arr);
        boolean take = false;
        if (target >= arr[index]) {
            take = subSetSum(index - 1, target - arr[index], dp, arr);
        }
        dp[index][target] = take || notTaken ? 1 : 0;
        return take || notTaken;
    }
}
/*
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
 */
