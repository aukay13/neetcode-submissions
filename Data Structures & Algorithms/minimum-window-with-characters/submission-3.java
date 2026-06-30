class Solution {
    public String minWindow(String s, String t) {
         int ansL = 0;
        int ansR = Integer.MAX_VALUE;
        int resLen = Integer.MAX_VALUE;

       HashMap<Character,Integer> hmapShort = new HashMap<>();
        
        
        for(int i=0;i<t.length();i++){
           if(hmapShort.containsKey(t.charAt(i))){
                hmapShort.put(t.charAt(i), hmapShort.get(t.charAt(i))+1);
           }
           else{
                hmapShort.put(t.charAt(i), 1);
           }
        }

        int i=0;

        HashMap<Character,Integer> hmapWindow = new HashMap<>();
        int have = 0, need = hmapShort.size();
        
        for(int j=0;j<s.length();j++){
           if(hmapWindow.containsKey(s.charAt(j))){
                hmapWindow.put(s.charAt(j), hmapWindow.get(s.charAt(j))+1);
           }
           else{
                hmapWindow.put(s.charAt(j), 1);
           }

           if(hmapShort.containsKey(s.charAt(j)) && hmapShort.get(s.charAt(j)) == hmapWindow.get(s.charAt(j))){
                have++;
           }

           while (have == need) {
                if(resLen >= j-i+1){
                    ansL = i;
                    ansR = j;
                    resLen = j-i+1;
                }
                hmapWindow.put(s.charAt(i), hmapWindow.get(s.charAt(i))-1);
                if(hmapShort.containsKey(s.charAt(i)) && hmapWindow.get(s.charAt(i)) < hmapShort.get(s.charAt(i))){
                    have--;
                }
                i++;
           }
        }

        String ans = "";

        if(resLen==Integer.MAX_VALUE){
            return "";
        }

        for(i=ansL;i<=ansR;i++){
            ans += s.charAt(i);
        }

        return ans;
    }
}
