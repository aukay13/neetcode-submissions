class Solution {
    public int coinChange(int[] coins, int amount) {
       int []dp = new int[amount+1];
       Arrays.fill(dp, -1);
       int ans = func(coins,amount,amount,dp);
       if(ans==amount+1){
        return -1;
       }
       return ans;
    }

    public int func(int[] coins, int currentAmount,int initialAmount,int[]dp) {
        
        if(currentAmount==0){
            return 0;
        }

        if(currentAmount<0){
            return initialAmount+1;
        }

        if(dp[currentAmount]!=-1){
            return dp[currentAmount];
        }

        int ans = initialAmount+1;
        for(int i=0;i<coins.length;i++){
            ans = Integer.min(ans,1+func(coins, currentAmount-coins[i],initialAmount,dp));
        }

        dp[currentAmount] = ans;
        return ans;
    }
}
