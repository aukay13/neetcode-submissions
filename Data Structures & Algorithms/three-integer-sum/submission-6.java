class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int left = i+1;
                int right = nums.length-1;
                while (left<right) {
                    if(nums[i] + nums[left] + nums[right] == 0){
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        int leftVal = nums[left];
                        while (left<nums.length && leftVal==nums[left]) {
                            left++;
                        }
                    }
                    else if(nums[i] + nums[left] + nums[right]<0){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
