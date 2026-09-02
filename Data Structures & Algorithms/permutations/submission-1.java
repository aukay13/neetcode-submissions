class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(new ArrayList<>(), nums, ans, 0, new HashSet<>());
        return ans;
    }

    public static void findPermutations(List<Integer> curr,int[] nums,List<List<Integer>> ans,int index,HashSet<Integer> used){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used.contains(nums[i])){
                curr.add(nums[i]);
                used.add(nums[i]);
                findPermutations(curr, nums, ans, index+1, used);
                curr.removeLast();
                used.remove(nums[i]);
            }
        }

    }
}
