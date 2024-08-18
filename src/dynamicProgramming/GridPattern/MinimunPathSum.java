package dynamicProgramming.GridPattern;

public class MinimunPathSum {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int m = arr.length , n = arr[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = arr[i][j];
                }
                else{
                    int up = arr[i][j] , left = arr[i][j];
                    if(i > 0)
                        up +=  dp[i -1][j];
                    else
                        up += Math.pow(10,9);

                    if(j > 0)
                        left +=  dp[i][j -1];
                    else
                        left += Math.pow(10,9);
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        System.out.println(dp[m - 1][n -1]);
    }
}
