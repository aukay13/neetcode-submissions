class Data{
    String value;
    int timestamp;

    Data(String s, int i){
        this.value = s;
        this.timestamp = i;
    }
}


class TimeMap {

    Map<String, List<Data>> store;

    
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){            
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        if(!store.containsKey(key)){
            return "";
        }
        List<Data> values = store.get(key);

        int low = 0;
        int high = values.size()-1;

        while (low<=high) {
            int mid = (low+high)/2;

            if(values.get(mid).timestamp == timestamp){
                return values.get(mid).value;
            }
            else if(values.get(mid).timestamp < timestamp){
                ans = values.get(mid).value;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return ans;

    }
}
