class Solution {
    public int climbStairs(int n) {
        int[]dp = new int[n+1];
        return func(n, dp);
    }

    public int func(int n, int[]dp){
        if(n==1 || n==2){
            return n;
        }

        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = func(n-1, dp) + func(n-2, dp);

        return dp[n];
    }
}
