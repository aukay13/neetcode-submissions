class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        HashSet<String> hs = new HashSet<>(wordDict);
        return func(s, hs,dp,0);

    }

    public boolean func(String s, HashSet<String> hs,int[]dp,int currIndex){

        if(currIndex==s.length()){
            return true;
        }

        if(dp[currIndex] != -1){
            return dp[currIndex] == 1;
        }

        for(int i=currIndex;i<s.length();i++){
            if(hs.contains(s.substring(currIndex, i+1))){
                if(func(s, hs, dp, i+1)){
                    dp[currIndex]=1;
                    return true;
                }
            }
        }

        dp[currIndex] = 0;
        return  false;

    }
}