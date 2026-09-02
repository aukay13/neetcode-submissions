class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(new ArrayList<>(), 0, target, candidates, ans,0);
        return ans;
    }

    public static void findCombinations(List<Integer> curr, int currSum,int target, int[] candidates,List<List<Integer>> ans, int index){
        if(currSum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(currSum>target){
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i==index || candidates[i]!=candidates[i-1]){
                curr.add(candidates[i]);
                currSum +=candidates[i];
                findCombinations(curr, currSum, target, candidates, ans,i+1);
                curr.removeLast();
                currSum-=candidates[i];
            }
        }
    }
}