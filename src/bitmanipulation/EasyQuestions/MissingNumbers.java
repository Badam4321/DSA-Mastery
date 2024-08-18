package bitmanipulation.EasyQuestions;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        //Hint is arrays values range 0 <= val <= n
        // we can do n * (n + 1) / 2 - totalsumOf array will get required ans
        int xor = 0;
        for(int val : nums){
            xor ^= val;
        }
        for(int i = 0 ; i <= nums.length ; i++){
            xor ^= i;
        }
        System.out.println(xor);


    }
}
/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 */
