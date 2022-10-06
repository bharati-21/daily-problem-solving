class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> store;
    public TimeMap() {
        store = new HashMap();
    }
    
    // Every <timestamp, value> pair will be in sorted order
    // as timestamp is strictly increasing
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)) {
            store.put(key, new ArrayList());
        }
        store.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // When there is no key, return ""
        if(!store.containsKey(key)) {
            return "";
        }
        
        ArrayList<Pair<Integer, String>> innerList = store.get(key);
        int left = 0;
        int right = innerList.size()-1;
        
        // If the first key is lesser than the timestamp value, we return ""
        if(timestamp < innerList.get(left).getKey()) {
            return "";
        }
        
        // If the last value is less than or equal to the timestamp, we return ""
        if(timestamp >= innerList.get(right).getKey()) {
            return innerList.get(right).getValue();
        }
                
        // search for the timestamp within bounds [0, size-1]        
        while(left <= right) {
            int mid = (left+right)/2;
            
            if(innerList.get(mid).getKey() == timestamp) {
                return innerList.get(mid).getValue();
            }
            if(innerList.get(mid).getKey() < timestamp) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return innerList.get(right).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
