class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(m,n,dp);
    }

    public int func(int m, int n, int [][]dp) {

        if(m==1 || n==1){
            dp[m][n] = 1;
            return 1;
        }

        if (dp[m][n]!=-1) {
            return dp[m][n];
        }
        
        dp[m][n] = func(m-1, n,dp) + func(m, n-1,dp);
        return dp[m][n];
    }
}