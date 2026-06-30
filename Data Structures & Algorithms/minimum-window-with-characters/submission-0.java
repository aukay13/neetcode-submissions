class Solution {

    public <K> boolean isSubMultiset(Map<K, Integer> m1, Map<K, Integer> m2) {
        if (m1 == null || m2 == null) return false; // policy: null => false
        for (Map.Entry<K, Integer> e : m1.entrySet()) {
            K k = e.getKey();
            int need = e.getValue();
            Integer have = m2.get(k);
            if (have == null || have < need) return false;
        }
        return true;
    }

    public String minWindow(String s1, String s2) {

        int ansL = -1;
        int ansR = -1;

       HashMap<Character,Integer> hmapShort = new HashMap<>();
        
        
        for(int i=0;i<s2.length();i++){
           if(hmapShort.containsKey(s2.charAt(i))){
                hmapShort.put(s2.charAt(i), hmapShort.get(s2.charAt(i))+1);
           }
           else{
                hmapShort.put(s2.charAt(i), 1);
           }
        }

        HashMap<Character,Integer> hmapLong = new HashMap<>();

        int i=0,j=0;
        boolean isFound = false;
        while (j<s1.length()){
            if(!hmapLong.containsKey(s1.charAt(j))){
                hmapLong.put(s1.charAt(j), 1);
            }
            else{
                hmapLong.put(s1.charAt(j), hmapLong.get(s1.charAt(j))+1);
            }

            if(isSubMultiset(hmapShort,hmapLong)){
                ansL = i;
                ansR = j;
                isFound = true;
                break;
            }
            j++;
        }

        if(!isFound){
            return "";
        }


        while (true) {

            while (isSubMultiset(hmapShort,hmapLong)) {
                hmapLong.put(s1.charAt(i), hmapLong.get(s1.charAt(i))-1);
                if(hmapLong.get(s1.charAt(i))==0){
                    hmapLong.remove(s1.charAt(i));
                }
                i++;
            }

            
            if(ansR-ansL > j-i+1){
                ansL = i-1;
                ansR = j;
            }

            boolean isJout = false;
            while (!isSubMultiset(hmapShort,hmapLong)){
                j++;
                if(j>=s1.length()){
                    isJout = true;
                    j--;
                    break;
                }
                if(!hmapLong.containsKey(s1.charAt(j))){
                    hmapLong.put(s1.charAt(j), 1);
                }
                else{
                    hmapLong.put(s1.charAt(j), hmapLong.get(s1.charAt(j))+1);
                }
            }

            if(ansR-ansL > j-i+1 && !isJout){
                ansL = i;
                ansR = j;
            }

            if(isJout){
                while (j-i+1>=s1.length()){
                    hmapLong.put(s1.charAt(i), hmapLong.get(s1.charAt(i))-1);
                    if(hmapLong.get(s1.charAt(i))==0){
                        hmapLong.remove(s1.charAt(i));
                    }
                    i++;
                    if(isSubMultiset(hmapShort,hmapLong) && (ansL-ansR > j-i+1)){
                        ansL = i;
                        ansR = j;
                    }

                }
                break;
            }

        }
            
        String ans = "";
        for(int k=ansL;k<=ansR;k++){
            ans += s1.charAt(k);
        }

        return ans;
    }

    
}
