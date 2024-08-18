package dynamicProgramming.SubsequencePattern;

import java.util.Arrays;
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount = 7;
        int ans = coinChange(coins,amount);
        System.out.println(ans);
        int res = tabulation(coins ,amount);
        System.out.println(res);
    }

    private static int tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        //base cases
        for(int i = 0 ; i <= amount ; i++){
            if(i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i = 1 ; i < n ; i++){
            for(int money = 0 ; money <= amount ; money++){
                int notTaken = dp[i - 1][money];
                int taken = Integer.MAX_VALUE;
                if(money >= coins[i])
                    taken = 1 + dp[i][money - coins[i]];
                dp[i][money] = Math.min(notTaken,taken);
            }
        }
        return dp[n - 1][amount];
    }

    private static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        int ans = coinChangeHelper(n - 1 , coins,amount,dp);
        if(ans >= Integer.MAX_VALUE)
            return -1;
        else
            return ans;

    }

    private static int coinChangeHelper(int i, int[] coins, int amount, int[][] dp) {
        //base case
        if(i == 0){
            if(amount % coins[0] == 0)
                return amount / coins[0];
            else
                return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1)
            return dp[i][amount];
        //explore all stuffs
        int notTaken = coinChangeHelper(i - 1,coins,amount,dp);
        int taken = Integer.MAX_VALUE;
        if(amount >= coins[i])
            taken = 1 + coinChangeHelper(i, coins, amount - coins[i], dp);
        //take minimum , out of all stuffs
        return dp[i][amount] = Math.min(notTaken,taken);

    }

}
