package dynamicProgramming.LongestCommonSubsequencePattern;

public class LongestPalindromicString {
    public static void main(String[] args) {
        String s = "bbbab";
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        int m = s.length();
        int[][] dp = new int[m + 1][m + 1] ;
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s.charAt(i - 1) == s1.charAt(j - 1) )
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
            }
        }
        System.out.println(dp[m][m]);

    }
}
/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
 */
