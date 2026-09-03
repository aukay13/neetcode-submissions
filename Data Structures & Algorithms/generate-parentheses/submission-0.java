class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(new ArrayList<>(), n, n, ans,n);
        return ans;
    }

    public void generate(List<Character> currList, int open, int close, List<String>ans, int n){
        if(currList.size()==2*n){
            ans.add(currList.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }

        if(open>0){
            currList.add('(');
            generate(currList, open-1, close, ans, n);
            currList.removeLast();
        }

        if(close>open){
            currList.add(')');
            generate(currList, open, close-1, ans, n);
            currList.removeLast();
        }
    }
}
