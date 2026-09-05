class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        HashMap<Character,List<Character>> hmap = new HashMap<>();
        hmap.put('2', List.of('a','b','c'));
        hmap.put('3', List.of('d','e','f'));
        hmap.put('4', List.of('g','h','i'));
        hmap.put('5', List.of('j','k','l'));
        hmap.put('6', List.of('m','n','o'));
        hmap.put('7', List.of('p','q','r','s'));
        hmap.put('8', List.of('t','u','v'));
        hmap.put('9', List.of('w','x','y','z'));
        findCombinations(digits, 0, ans, new StringBuilder(""), hmap);
        return ans;
    }

    public void findCombinations(String digits, int currIndex, List<String> ans, StringBuilder currString, HashMap<Character,List<Character>> hmap){

        if(currString.length()==digits.length()){
            ans.add(currString.toString());
            return;
        }

        List<Character> indexArray = hmap.get(digits.charAt(currIndex));

        for(int i=0;i<indexArray.size();i++){
            currString.append(indexArray.get(i));
            findCombinations(digits, currIndex+1, ans, currString, hmap);
            currString.deleteCharAt(currString.length()-1);
        }

    }
}
