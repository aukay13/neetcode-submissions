class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int []freq1 = new int[26];
        int []freq2 = new int[26];

        for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s1.length();i++){
            freq2[s2.charAt(i)-'a']++;
        }

        int i=0, j=s1.length()-1;

        while (true) {
            boolean flag = true;
            for(int k=0;k<26;k++){
                if(freq1[k]!=freq2[k]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return flag;
            }
            if(j==s2.length()-1){
                break;
            }
            freq2[s2.charAt(i)-'a']--;
            freq2[s2.charAt(j+1)-'a']++;
            i++;
            j++;
        }
        return false;
    }
}
