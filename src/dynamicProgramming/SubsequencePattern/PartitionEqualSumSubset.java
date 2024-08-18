package dynamicProgramming.SubsequencePattern;

import java.time.chrono.MinguoDate;

public class PartitionEqualSumSubset {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        //1,2,3,5
        boolean res = canPartition(nums);
        if(res)
            System.out.println("yes we can");
        else
            System.out.println("we can't");
    }

    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums)
            sum += val;
        if(sum % 2 == 1)
            return false;
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return canPartitionHelper(nums.length - 1 , target,nums,dp);
    }

    private static boolean canPartitionHelper(int i, int target, int[] nums, Boolean[][] dp) {
        if(target == 0)
            return true;
        if(i == 0)
            return target == nums[i];
        if(dp[i][target] != null)
            return dp[i][target];
        boolean notTaken = canPartitionHelper(i - 1, target, nums, dp);
        boolean take = false;
        if(target >= nums[i])
            take = canPartitionHelper(i -1, target - nums[i], nums, dp);
        return dp[i][target] = take || notTaken;

    }
}
/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Intuition
This problem slightly changed problem of subsetsum equals k
observations
consider two subsets names are s1 and s2
so sum of subset1 s1 + sum of subset2 s2 = total sum of arrays right
if total sum of array is odd which means we can't split into parts directly we returns false;
else our target is total sum of array / 2


 */
