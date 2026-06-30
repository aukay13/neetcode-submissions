class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1){
            return s.length();
        }

        HashMap<Character,Integer> hmap = new HashMap<>();
        int ans = 1;
        hmap.put(s.charAt(0),1);
        int i=0,j=1;
        while (j<s.length()) {
            if(!hmap.containsKey(s.charAt(j))){
                hmap.put(s.charAt(j),1);
                ans = Integer.max(ans, j-i+1);
            }
            else{
                while (hmap.containsKey(s.charAt(j)) && i<j) {
                    hmap.put(s.charAt(i),hmap.get(s.charAt(i))-1);
                    if(hmap.get(s.charAt(i))==0){
                        hmap.remove(s.charAt(i));
                    }
                    i++;
                }
                hmap.put(s.charAt(j), 1);
            }
            j++;
        }

        return ans; 
    }
}
