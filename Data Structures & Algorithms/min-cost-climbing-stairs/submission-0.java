class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[]dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return func(cost, dp, cost.length);
    }

    public int func(int[]cost,int dp[], int n){

        if(n==0 || n==1){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n] = Integer.min(func(cost, dp, n-1)+cost[n-1], func(cost, dp, n-2)+cost[n-2]);
        return dp[n];
    }
}