class Solution {
    public int change(int amount, int[] coins) {
        int [][]dp = new int[amount+1][coins.length];
        for(int[]a:dp){
            Arrays.fill(a, -1);
        }
        return func(amount, coins, 0,dp);
    }

    public int func(int amount, int[] coins, int index,int[][]dp) {
        if(amount==0){
            return 1;
        }
        if(amount<0){
            return 0;
        }

        if(dp[amount][index]!=-1){
            return dp[amount][index];
        }



        int ans = 0;
        for(int i=index;i<coins.length;i++){
            ans += func(amount-coins[i], coins, i,dp);
        }


        dp[amount][index]=ans;
        return ans;

    }
}