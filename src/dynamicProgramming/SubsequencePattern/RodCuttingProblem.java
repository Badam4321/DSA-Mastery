package dynamicProgramming.SubsequencePattern;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int n = 5;
        int[] price = {2 , 5 , 7 , 8 , 10};
        //Note : similar problem of 0/1Knapsack problem
        int ans = cutRod(price , n);
        System.out.println(ans);
        System.out.println(tabulation(n,price));
    }

    private static int tabulation(int len, int[] price) {
        int n = price.length;
        int[][] dp = new int[n][len + 1];
        for(int t = 0 ; t <= len ; t++){
            dp[0][t] = t * price[0];
        }
        for(int i = 1 ; i < n ; i++){
            for(int t = 0 ; t <= len ; t++){
                int notTaken = dp[i - 1][t];
                int taken = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if(t >= rodLength){
                    taken = price[i] + dp[i][t - rodLength];
                }
                //take maximum out of all possible ways
                dp[i][t] = Math.max(notTaken,taken);

            }
        }
        return dp[n - 1][len];

    }

    private static int cutRod(int[] price, int n) {
        int ind = price.length;
        int[][] dp = new int[ind][n + 1];
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        int max = rodCutHelper( ind - 1 , price , n , dp);
        return max;
    }

    private static int rodCutHelper(int i, int[] price, int n, int[][] dp) {
        //base cases
        if(i == 0){
            return n * price[0];
        }
        if(dp[i][n] != -1)
            return dp[i][n];
        //explorer all stuffs
        int notTaken = rodCutHelper(i - 1, price, n,dp);
        int taken = Integer.MIN_VALUE;
        int rodLength = i + 1;
        if(n >= rodLength){
            taken = price[i] + rodCutHelper(i, price, n - rodLength,dp);
        }
        //take maximum out of all possible ways
        return dp[i][n] = Math.max(notTaken,taken);

    }
}

/*
Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.

Note:
1. The sizes will range from 1 to ‘N’ and will be integers.
2. The sum of the pieces cut should be equal to ‘N’.
3. Consider 1-based indexing.
IP : arr = [2 5 7 8 10] n = 5
OP : 12
 */

