class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> dp = new HashMap<>();  
        return func(nums, target, 0,dp);
    }

    public int func(int[] nums, int target, int index,HashMap<String, Integer> dp ){

        if(index==nums.length){
            if(target==0){
                return 1;
            }
            return 0;
        }

        if(dp.containsKey(target+","+index)){
            return dp.get(target+","+index);
        }
        
        dp.put(target+","+index, func(nums, target-nums[index], index+1,dp) + func(nums, target+nums[index], index+1,dp));
        return dp.get(target+","+index);
    }
}