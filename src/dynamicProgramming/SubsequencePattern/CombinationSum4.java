package dynamicProgramming.SubsequencePattern;

public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1 , 2 , 3};
        int target = 4;
        System.out.println(combinationSum(nums,target));

    }

    private static int combinationSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int currTarget = 1 ; currTarget <= target ; currTarget ++){
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i] <= currTarget)
                    dp[currTarget] += dp[currTarget - nums[i]];
            }
        }
        return dp[target];
    }
}
/*
377. Combination Sum IV
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 */
