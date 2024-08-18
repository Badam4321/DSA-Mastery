package dynamicProgramming.LongestIncreasingSubsequencePatterns;

public class    LISUsingDp {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int len = lengthOfLIS(nums);
        System.out.println(len);

    }

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            dp[i] = 1;
            for(int j = i -1 ; j >= 0; j--){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i] , 1 + dp[j]);
            }
            maxLength = Math.max(maxLength , dp[i]);
        }
        return maxLength;
    }
}
/*
Given an integer array nums, return the length of the longest strictly increasing
subsequence
.Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Time complexity : O(n^2)
space complexity : O(n)
 */
