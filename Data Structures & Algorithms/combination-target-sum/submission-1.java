class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(new ArrayList<>(), 0, target, candidates, ans,0);
        return ans;
    }

    public void findCombinations(List<Integer> curr, int currSum,int target, int[] candidates,List<List<Integer>> ans, int start){
        if(currSum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(currSum>target){
            return;
        }

        for(int i=start; i<candidates.length; i++){
            curr.add(candidates[i]);
            currSum +=candidates[i];
            findCombinations(curr, currSum, target, candidates, ans,i);
            curr.removeLast();
            currSum-=candidates[i];
        }

    }
}
