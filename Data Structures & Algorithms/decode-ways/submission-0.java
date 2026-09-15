class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return func(s, dp, 0);
    }
    public int func(String s, int[] dp, int i){

        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int ans1 = func(s, dp, i + 1);

        int ans2 = 0;

        if(i + 1 < s.length()){
            int num = Integer.parseInt(s.substring(i, i + 2));

            if(num >= 10 && num <= 26){
                ans2 = func(s, dp, i + 2);
            }
        }

        return dp[i] = ans1 + ans2;
    }
}
