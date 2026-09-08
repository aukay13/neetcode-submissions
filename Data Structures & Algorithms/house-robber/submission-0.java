class Solution {
    public int rob(int[] nums) {
        int[]dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return func(nums, dp, 0);
    }

    public int func(int[]nums, int dp[], int currIdex){
        if(currIdex>=nums.length){
            return 0;
        }

        if(dp[currIdex]!=-1){
            return dp[currIdex];
        }

        dp[currIdex] = Integer.max(nums[currIdex]+func(nums, dp, currIdex+2), func(nums, dp, currIdex+1));
        return dp[currIdex];
    }
}