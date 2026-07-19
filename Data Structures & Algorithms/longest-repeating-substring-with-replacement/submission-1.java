class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int left = 0,right=0,ans=0;
        while (right<s.length()) {
            if(!hmap.containsKey(s.charAt(right))){
                hmap.put(s.charAt(right), 1);
            }
            else{
                hmap.put(s.charAt(right), hmap.get(s.charAt(right))+1);
            }

            while ((right-left+1)-Collections.max(hmap.values()) > k) {
                hmap.put(s.charAt(left), hmap.get(s.charAt(left))-1);
                left++;
            }

            ans = Integer.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}
