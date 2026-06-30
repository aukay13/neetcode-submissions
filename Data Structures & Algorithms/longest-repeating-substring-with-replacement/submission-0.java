class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,ans=0;
        HashMap<Character,Integer> hmap = new HashMap<>();

        while (j<s.length()) {
            if(!hmap.containsKey(s.charAt(j))){
                hmap.put(s.charAt(j), 1);
            }
            else{
                hmap.put(s.charAt(j), hmap.get(s.charAt(j))+1);
            }

            if(j-i+1 - Collections.max(hmap.values()) <=k){
                ans = Integer.max(ans,j-i+1);
            }
            else{
                while (j-i+1-Collections.max(hmap.values()) > k) {
                    hmap.put(s.charAt(i),hmap.get(s.charAt(i))-1);
                    i++;
                }

            }
            j++;
            
        }
        return ans;
    }
}
