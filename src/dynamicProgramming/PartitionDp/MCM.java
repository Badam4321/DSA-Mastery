package dynamicProgramming.PartitionDp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MCM {
    static int[][] dp;
    public static void main(String[] args) {
        int[] arr = {10 ,15 , 20  ,25};
        //m1 = a0 a1 , m2 = a1 a2  m3 = a2 a3
        //m1 * (m2 * m3) or (m1 * m2) * m3
        int n = arr.length;
        dp = new int[n][n];
        for(int[] a : dp)
            Arrays.fill(a , -1);
        int res = MCMHelper(arr , 1 , arr.length - 1);
        System.out.println(res);
    }

    private static int MCMHelper(int[] arr, int i, int j) {
        if(i == j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int res = Integer.MAX_VALUE;
        for(int k = i ; k < j ; k++){
            res = Math.min(res , MCMHelper(arr , i , k) + MCMHelper(arr , k + 1 , j) + arr[i - 1] * arr[j] * arr[k]);
        }
        return dp[i][j]= res;
    }
}


