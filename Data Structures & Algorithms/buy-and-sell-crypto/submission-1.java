class Solution {
    public int maxProfit(int[] prices) {
        int smallest_till_now = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-smallest_till_now > profit){
                profit = prices[i]-smallest_till_now;
            }
            if(prices[i] < smallest_till_now){
                smallest_till_now = prices[i];
            }
        }
        return profit;
    }
}
