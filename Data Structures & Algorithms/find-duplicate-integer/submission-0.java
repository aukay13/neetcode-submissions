class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(nums[i]<0){
                n *=-1;
            }
            if(nums[n]<0){
                return n;
            }
            nums[n] *= -1;
        }
        return 0;
    }
}
