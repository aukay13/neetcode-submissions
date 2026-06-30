class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> res = new HashMap<>();

        for(String s: strs){
            
            int[] freq = new int[26];
            for(char x: s.toCharArray()){
                freq[x-'a']++;
            }

            String key = Arrays.toString(freq);

            if(!res.containsKey(key)){
                res.put(key, new ArrayList<>());
            }
            
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
        
    }
}
