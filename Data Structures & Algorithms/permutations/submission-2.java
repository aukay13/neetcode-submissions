class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(new ArrayList<>(), nums, ans, new HashSet<>());
        return ans;
    }

    public static void findPermutations(List<Integer> curr,int[] nums,List<List<Integer>> ans,HashSet<Integer> used){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used.contains(nums[i])){
                curr.add(nums[i]);
                used.add(nums[i]);
                findPermutations(curr, nums, ans, used);
                curr.removeLast();
                used.remove(nums[i]);
            }
        }

    }
}
