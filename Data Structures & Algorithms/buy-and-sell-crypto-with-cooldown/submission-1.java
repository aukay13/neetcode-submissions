class Solution {
    public int maxProfit(int[] prices) {
        int[][]dp = new int[prices.length][2];
        for(int[]a:dp){
            Arrays.fill(a, -1);
        }
        return func(prices, 0, true, dp);
    }

    public int func(int[]prices, int index, boolean canBuy,int[][]dp){

        if(index>=prices.length){
            return 0;
        }

        if(canBuy){
            if(dp[index][1]!=-1){
                return dp[index][1];
            }
            return dp[index][1] = Math.max(-prices[index] + func(prices, index+1, false, dp), func(prices, index+1, true, dp));
        }
        else{
            if(dp[index][0]!=-1){
                return dp[index][0];
            }
            return dp[index][0] = Math.max(prices[index] + func(prices, index+2, true, dp), func(prices, index+1, false, dp));
        }

    }
}