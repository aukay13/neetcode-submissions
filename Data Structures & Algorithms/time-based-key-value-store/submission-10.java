class TimeMap {

    HashMap<String,ArrayList<String[]>> hm ;

    public TimeMap() {
        hm = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)){
            ArrayList<String[]> a = new ArrayList<>();
            a.add(new String[]{value,String.valueOf(timestamp)});
            hm.put(key, a);
        }
        else{
            ArrayList<String[]> val = hm.get(key);
            val.add(new String[]{value,String.valueOf(timestamp)});
        }
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key) || Integer.valueOf(hm.get(key).get(0)[1]) > timestamp){
            return "";
        }
        if(hm.containsKey(key) && Integer.valueOf(hm.get(key).getLast()[1]) <= timestamp){
            return hm.get(key).getLast()[0];
        }
        return searchInsideList(hm.get(key), timestamp)[0];
    }

        public String[] searchInsideList(ArrayList<String[]> sa, int timestamp){
        if(sa.size()==1){
            return sa.get(0);
        }
        int left = 0;
        int right = sa.size()-1;
        int mid = -1;
        while (left<right) {
            mid = left + (right-left)/2;
            if(sa.get(mid)[1] == String.valueOf(timestamp)){
                return sa.get(mid);
            }
            if(Integer.valueOf(sa.get(mid)[1]) > timestamp){
                right = mid-1;
            }
            else{
                left = mid;
            }
            if(right==left+1){
                break;
            }
        }
        return sa.get(left);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */