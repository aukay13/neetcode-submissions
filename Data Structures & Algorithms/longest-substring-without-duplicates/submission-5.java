class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1){
            return s.length();
        }

        HashSet<Character> hmap = new HashSet<>();
        int ans = 1;
        hmap.add(s.charAt(0));
        int i=0,j=1;
        while (j<s.length()) {
            if(!hmap.contains(s.charAt(j))){
                hmap.add(s.charAt(j));
                ans = Integer.max(ans, j-i+1);
            }
            else{
                while (hmap.contains(s.charAt(j))) {
                    hmap.remove(s.charAt(i));
                    i++;
                }
                hmap.add(s.charAt(j));
            }
            j++;
        }

        return ans;
    }
}
