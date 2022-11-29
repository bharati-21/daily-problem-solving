class RandomizedSet {
    Map<Integer, Integer> values;
    List<Integer> valueIndices;
    public RandomizedSet() {
        values = new HashMap();
        valueIndices = new ArrayList();
    }
    
    public boolean insert(int val) {
        if(values.containsKey(val)) return false;
        
        // insert the current value in the last index
        int index = values.size();
        values.put(val, index);
        // insert the current value in the last index
        valueIndices.add(index, val);
                
        return true;
    }
    
    public boolean remove(int val) {
        if(!values.containsKey(val)) return false;
        
        // Get the index of current val
        int valIndex = values.get(val);
        // Get the last index and the last val
        int lastIndex = valueIndices.size() - 1;
        int lastVal = valueIndices.get(lastIndex);
        
        // removes curr element from map
        values.remove(val);
        // removes curr element from index
        valueIndices.remove(valIndex);
        if(val == lastVal) {
            return true;
        }
        
        // add the last value to valIndex in the list
        valueIndices.add(valIndex, lastVal);
        // set the lastVal index as valIndex
        values.put(lastVal, valIndex);
        // remove the last index from the list
        valueIndices.remove(lastIndex);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(valueIndices.size());
        
        return valueIndices.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
