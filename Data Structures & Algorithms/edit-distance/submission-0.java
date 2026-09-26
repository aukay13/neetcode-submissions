class Solution {
    public int minDistance(String word1, String word2) {
        int [][]dp = new int[word1.length()][word2.length()];
        for(int[]a:dp){
            Arrays.fill(a, -1);
        }
        return func(word1, word2, 0, 0,dp);
    }

    public int func(String word1, String word2, int index1, int index2,int[][]dp){
        if(index1==word1.length() && index2==word2.length()){
            return 0;
        }
        else if(index1==word1.length()){
            return word2.length()-index2;
        }
        else if(index2==word2.length()){
            return word1.length()-index1;
        }

        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }

        if(word1.charAt(index1)==word2.charAt(index2)){
            dp[index1][index2] = func(word1, word2, index1+1, index2+1,dp);
            return dp[index1][index2];
        }

        dp[index1][index2] = 1 + Math.min(func(word1, word2, index1+1, index2,dp), Math.min(func(word1, word2, index1, index2+1,dp), func(word1, word2, index1+1, index2+1,dp)));
        return dp[index1][index2];

    }

}