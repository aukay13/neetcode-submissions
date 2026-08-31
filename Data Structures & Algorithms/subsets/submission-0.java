class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recFunc(new ArrayList<>(), 0, nums, ans);
        return ans;
    
    }

    public void recFunc(List<Integer> curr,int index, int[]nums,List<List<Integer>> ans){

        if(index==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        recFunc(curr, index+1, nums, ans);

        curr.removeLast();
        recFunc(curr, index+1, nums, ans);

    }
}
