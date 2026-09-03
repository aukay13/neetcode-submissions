class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(new ArrayList<>(), nums, ans, 0);
        return ans;
    }

    public static void findSubsets(List<Integer> currList, int []candidates, List<List<Integer>> ans,int start){

        ans.add(new ArrayList<>(currList));

        for(int i=start;i<candidates.length;i++){
            if(i==start || candidates[i]!=candidates[i-1]){
                currList.add(candidates[i]);
                findSubsets(currList, candidates,ans,i+1);
                currList.removeLast();
            }
        }

    }
}