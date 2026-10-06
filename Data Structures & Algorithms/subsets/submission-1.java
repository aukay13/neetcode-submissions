class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        func(nums, new ArrayList<>(), ans,0);
        return ans;
    }

    public void func(int[] nums, ArrayList<Integer> currList, List<List<Integer>> ans ,int index) {

        ans.add(new ArrayList<>(currList));
        

        for(int i=index;i<nums.length;i++){      
            currList.add(nums[i]);
            func(nums,currList, ans,i+1);
            currList.removeLast();
        }
    }
}
