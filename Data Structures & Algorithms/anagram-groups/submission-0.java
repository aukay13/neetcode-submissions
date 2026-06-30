class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashSet<String> hset = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(!hset.contains(strs[i])){
                hset.add(strs[i]);
                List<String> subList = new ArrayList<>();
                subList.add(strs[i]);
                for(int j=i+1;j<strs.length;j++){
                    if(isAnagram(strs[i], strs[j])){
                        subList.add(strs[j]);
                        hset.add(strs[j]);
                    }
                }
                ans.add(subList);
            }
        }

        return ans;
    }
    
    public  boolean isAnagram(String s, String t) {
        int [] freq1 = new int[26];
        int [] freq2 = new int[26];

        for(int i=0;i<s.length();i++){
            freq1[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t.length();i++){
            freq2[t.charAt(i)-'a']++;
        }

        for(int i=0;i<freq1.length;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }

        return true;
    }

}
