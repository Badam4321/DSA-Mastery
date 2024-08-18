package dynamicProgramming.LongestCommonSubsequencePattern;

public class MinInsertionToMakePalindrome {
    public static void main(String[] args) {
        String s = "leetcode";
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
        System.out.println(s.length() - dp[m][m]);
    }
}
/*
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.
Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm"
Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 */
