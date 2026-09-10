class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[]dp1 = new int[nums.length+1];
        int[]dp2 = new int[nums.length+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Integer.max(func(nums, 0,nums.length-2, dp1),func(nums, 1,nums.length-1, dp2));
    }

    public int func(int[]nums, int currIdex, int end,int[]dp){
        if(currIdex>end){
            return 0;
        }
        
        if(dp[currIdex]!=-1){
            return dp[currIdex];
        }

        dp[currIdex] = Integer.max(nums[currIdex]+func(nums, currIdex+2,end,dp), func(nums, currIdex+1,end,dp));
        return dp[currIdex];
    }
}