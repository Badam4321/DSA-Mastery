package array.TwoPointersPatterns;

public class FindCommonValue {
    public  static int getCommon(int[] nums1 , int[] nums2){
        int p1 = 0 , p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2])
                return nums1[p1];
            else if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else if(nums1[p1] > nums2[p2]){
                p2++;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,6};
        int[] nums2 = {2,3,4,5};
        System.out.println(getCommon(nums1,nums2));
    }
}
/*
Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
 */
