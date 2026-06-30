class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        int ans = 1;
        for(int i=0;i<nums.length;i++){
            int k = 1;
            if(!hs.contains(nums[i]-1)){
                while (hs.contains(nums[i]+k)) {
                    k++;
                }
            }
            ans = Integer.max(ans, k);
        }

        return ans;
    }
}
