class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList();
        }
        
        List<List<String>> groups = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        
        for(String str: strs) {
            String countRepresentation = getCountRepresentation(str);
            if(!map.containsKey(countRepresentation)) {
                map.put(countRepresentation, new ArrayList());
            }
            map.get(countRepresentation).add(str);
        }
        
        for(String countRepresentation: map.keySet()) {
            groups.add(map.get(countRepresentation));
        }
        
        return groups;
    }
    
    private String getCountRepresentation(String s) {
        int[] count = new int[26];
        
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }
        
        return Arrays.toString(count);
    }
}
