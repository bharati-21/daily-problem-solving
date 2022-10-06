class TimeMap {
    // store by key => [timestamp => value]
    Map<String, Map<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // If the store already contains the key
        if(store.containsKey(key)) {
            store.get(key).put(timestamp, value);
        }
        // If not, add a mew key and [timestamp => value] pair for it
        else {
            Map<Integer, String> keyValue = new HashMap<>();
            keyValue.put(timestamp, value);
            store.put(key, keyValue);
        }
    }
    
    public String get(String key, int timestamp) {
        int maxTimeStamp = -1;
        
        // if the key is present
        if(store.containsKey(key)) {
            // Then find a key such that it's the largest stamp 
            // smaller than given time stamp
            for(int k: store.get(key).keySet()) {
                if(timestamp == k) {
                    return store.get(key).get(timestamp);
                }
                maxTimeStamp = k < timestamp ? Math.max(maxTimeStamp, k) : maxTimeStamp;
            }
        }
        
        // If no timestamp found
        if(maxTimeStamp > timestamp || maxTimeStamp == -1) {
            return "";
        }
        
        return store.get(key).get(maxTimeStamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
