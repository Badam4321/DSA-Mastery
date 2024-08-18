package dynamicProgramming.FibonaccePattern;

import java.util.Arrays;


public class FibonacciNumber {
    public static void main(String[] args) {
        int number = 8;
        //Recurrecne relation is fib(n) = fib(n - 1) + fib(n -2)
        int result = memoization(number);
        System.out.println(result);
        int ans = tabulation(number);
        System.out.println(ans);
        System.out.println(spaceOptimization(number));

    }

    private static int spaceOptimization(int number) {
        int prev2 = 0 , prev1 = 1;
        for(int i = 2 ; i <= number ; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    private static int tabulation(int number) {
        int[] dp = new int[number + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= number ; i++){
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[number];

    }

    private static int memoization(int number) {
        int[] dp = new int[number + 1];
        Arrays.fill(dp,-1);
        return fib(number,dp);
    }

    private static int fib(int number,int[] dp) {
        if(number <= 1)
            return number;
        if(dp[number] != -1)
            return dp[number];
        return dp[number] = fib(number-1,dp) + fib(number -2 , dp);
    }
}
