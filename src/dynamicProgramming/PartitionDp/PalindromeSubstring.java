package dynamicProgramming.PartitionDp;

public class PalindromeSubstring {
    public static void main(String[] args) {
        String s = "racecar";
        int size = s.length();
        boolean dp[][] = new boolean[size][size];
        int palindromeCount = 0;
        for (int diff = 0; diff < size; diff++) {
            for (int i = 0, j = diff; j < size; i++, j++) {
                if (diff == 0) {
                    dp[i][j] = true;
                } else if (diff == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j]) {
                    palindromeCount++;
                }
            }
        }
        System.out.println(palindromeCount);

    }
}
/*
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 */

