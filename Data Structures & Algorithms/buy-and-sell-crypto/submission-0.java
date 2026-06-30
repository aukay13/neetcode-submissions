class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int max = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(max<prices[i]){
                max = prices[i];
            }
            else{
                ans = Integer.max(ans,max-prices[i]);
            }
        }
        return ans;
    }
}
