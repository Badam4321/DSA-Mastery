package dynamicProgramming.bestTimeBuyAndSellTheStock;
import java.util.*;
public class BestTimeBuyAndSellTheStockII {
    static int[][] dp;
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    private static int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n + 1][2];
        dp = new int[prices.length][2];
        for(int[] arr : dp)
            Arrays.fill(arr , -1);
        return profitHelper(prices , 0 , 1);

    }
    public static int profitHelper(int[] prices , int index , int buy){
        if(index == prices.length)
            return 0;
        int profit = 0;
        if(dp[index][buy] != -1)
            return dp[index][buy];
        if(buy == 1)
            profit = Math.max(- prices[index] + profitHelper(prices , index + 1 , 0) , 0 + profitHelper(prices , index + 1 , 1));
        else
            profit = Math.max(prices[index] + profitHelper(prices , index + 1 , 1) , 0 + profitHelper(prices , index + 1 , 0));
        return dp[index][buy] = profit;

    }
}
/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 */
