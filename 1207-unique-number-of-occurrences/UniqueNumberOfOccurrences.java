class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap();
        
        for(int num: arr) {
            occurrences.put(num, 
                occurrences.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> uniqueOccurrences = new HashSet<>();
        for(int count: occurrences.values()) {
            uniqueOccurrences.add(count);
        }
        
        return (uniqueOccurrences.size() == occurrences.size());
    }
}
