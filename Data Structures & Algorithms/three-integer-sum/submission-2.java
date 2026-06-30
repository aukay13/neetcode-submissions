class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int left = i+1;
                int right = nums.length-1;
                while (left<right) {
                    if(nums[i] + nums[left] + nums[right] == 0){
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        int l = nums[left];
                        int r = nums[right];
                        while (left<nums.length && nums[left]==l) {
                            left++;
                        }
                        while (right>=0 && nums[right]==r) {
                            right--;
                        }
                    }
                    else if(nums[i] + nums[left] + nums[right] > 0){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
