class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int dp[][] = new int[text1.length()][text2.length()];
        for(int[]r:dp){
            Arrays.fill(r, -1);;
        }
        return func(text1, text2, 0, 0,dp);

    }


    public int func(String small, String large,int s, int l,int [][]dp) {

        if(s==small.length() || l==large.length()){
            return 0;
        }

        if(dp[s][l]!=-1){
            return dp[s][l];
        }
        
        if(small.charAt(s)==large.charAt(l)){
            dp[s][l] = 1 + func(small, large, s+1, l+1, dp);
            return dp[s][l];
        }

        dp[s][l] = Math.max(func(small, large, s+1, l, dp), func(small, large, s, l+1, dp));
        return dp[s][l];

    }
}