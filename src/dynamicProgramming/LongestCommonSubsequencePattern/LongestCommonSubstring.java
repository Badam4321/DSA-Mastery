package dynamicProgramming.LongestCommonSubsequencePattern;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcjklp" , s2 = "acjkp";
        //we can take same LCS code whenever it non matched we weill make dp[i][j] == 0
        int m = s1.length() , n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(dp[i][j] , ans);
                }
                else
                    dp[i][j] = 0;
            }
        }
        System.out.println(ans);
    }
}
/*
You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.



A substring is a continuous segment of a string. For example, "bcd" is a substring of "abcd", while "acd" or "cda" are not.



Example:
Input: ‘str1’ = “abcjklp” , ‘str2’ = “acjkp”.

Output: 3

Explanation:  The longest common substring between ‘str1’ and ‘str2’ is “cjk”, of length 3.
 */
