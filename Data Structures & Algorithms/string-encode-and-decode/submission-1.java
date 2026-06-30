class Solution {

    public String encode(List<String> strs) {
        String s = "";
        for(int i=0;i<strs.size();i++){
            s = s + "#"+ strs.get(i).length()+ "#" + strs.get(i);
        }

        return s;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            String length = "";
            while (str.charAt(i+1)!='#') {
                length += str.charAt(i+1);
                i++;
            }
            i++;
            int currLength = Integer.parseInt(length);
            int k=0; String currWord = "";
            while (k<currLength) {
                currWord += str.charAt(++i);
                k++;
            }
            i++;
            ans.add(currWord);
        }
        return ans;
    }
}
