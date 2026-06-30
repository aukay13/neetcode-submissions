class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i], hmap.get(nums[i])+1);
            }
            else{
                hmap.put(nums[i], 1);
            }
        }

        List<Integer> []freq = new List[nums.length+1];

        for(int i=0;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }

        for(Integer n: hmap.keySet()){
            freq[hmap.get(n)].add(n);
        }

        List<Integer> ansList = new ArrayList<>();

        int i=freq.length-1;
        while (ansList.size()!=k) {
            if(freq[i].size()!=0){
                for(int j=0;j<freq[i].size();j++){
                    ansList.add(freq[i].get(j));
                }
            }
            i--;
        }

        return ansList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
