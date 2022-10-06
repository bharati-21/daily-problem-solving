class TimeMap {
    Map<String, TreeMap<Integer, String>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)) {
            TreeMap<Integer, String> innerMap = new TreeMap<>();
            store.put(key, innerMap);
        }
        store.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)) {
            return "";
        }
        
        int maxTimestamp = -1;
        
        TreeMap<Integer, String> innerMap = store.get(key);
        
        int firstKey = innerMap.firstKey();
        int lastKey = innerMap.lastKey();
        
        // If the given timestamp is less than the smallest key => then you return empty string
        if(firstKey > timestamp) {
            return "";
        }
        
        // If the time stamp is present, return the value mapped to it
        if(innerMap.containsKey(timestamp)) {
            return innerMap.get(timestamp);
        }
        
        // If the last key is smaller than time stamp, then you just return it.
        if(lastKey < timestamp) {
            return innerMap.get(lastKey);
        }
        
        // else return the greatest value smaller than timestamp
        Integer timestamp_prev = innerMap.floorKey(timestamp);
            
        return timestamp_prev == null ? "" : innerMap.get(timestamp_prev);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
