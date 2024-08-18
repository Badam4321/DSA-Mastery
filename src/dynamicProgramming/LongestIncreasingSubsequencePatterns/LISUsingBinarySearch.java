package dynamicProgramming.LongestIncreasingSubsequencePatterns;

import java.util.ArrayList;
import java.util.List;

public class LISUsingBinarySearch {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        List<Integer> subsequence = new ArrayList<>();
        subsequence.add(nums[0]);
        for(int i = 1 ; i < nums.length ; i++){

            if(nums[i] > subsequence.get(subsequence.size() - 1)){
                subsequence.add(nums[i]);
            }
            else{
                int lower_bound = lowerBound(subsequence , nums[i]);
                subsequence.set(lower_bound,nums[i]);
            }

        }
        System.out.println(subsequence.size());
        System.out.println(subsequence);
    }

    private static int lowerBound(List<Integer> subsequence, int target) {
        int low = 0 , high = subsequence.size() - 1;
        int lower_bound = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(subsequence.get(mid) >= target){
                lower_bound = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return lower_bound;
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
Time complexity : O(nlogn)
space complexity : O(n)
 */
