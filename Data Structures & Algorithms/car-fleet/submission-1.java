class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length==1){
            return 1;
        }
        
        Map<Integer,Integer> tmap = new TreeMap<>();
        for(int i=0;i<position.length;i++){
            tmap.put(position[i], speed[i]);
        }


        Stack<Double> st = new Stack<>();

        for(Map.Entry<Integer,Integer> entry : tmap.entrySet()){
            st.add((double)(target-entry.getKey())/entry.getValue());
        }

        int ans = 1;
        double max = st.peek();

        while (!st.isEmpty()) {
            double curr = st.peek();
            if(st.pop()>max){
                ans++;
                max = curr;
            }
        }

        return ans;
    }
}
