class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int dp[][] = new int[s1.length()][s2.length()];
        for(int[]a:dp){
            Arrays.fill(a, -1);;
        }
        return func(s1, s2, s3, 0, 0, 0,dp);
    }

    public boolean func(String s1, String s2, String s3, int index1, int index2, int index3,int[][]dp){

        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        if(index3==s3.length()){
            return true;
        }

        if(index2==s2.length()){
            if(s1.substring(index1).equals(s3.substring(index3))){
                return true;
            }
            return false;
        }

        if(index1==s1.length()){
            if(s2.substring(index2).equals(s3.substring(index3))){
                return true;
            }
            return false;
        }

        if(dp[index1][index2]!=-1){
            return dp[index1][index2]==0?false:true;
        }

        boolean ans1=false,ans2=false;
        if(s1.charAt(index1)==s3.charAt(index3)){
            ans1 = func(s1, s2, s3, index1+1, index2, index3+1,dp);
        }
        

        if(s2.charAt(index2) == s3.charAt(index3)){
            ans2 = func(s1, s2, s3, index1, index2+1, index3+1,dp);
        }

        if(ans1 || ans2){
            dp[index1][index2] = 1;
        }
        else{
            dp[index1][index2] = 0;
        }

        return ans1 || ans2;
    }

}