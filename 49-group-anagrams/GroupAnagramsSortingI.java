class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        
        for(String str: strs) {
            String sortedStr = getSortedString(str); 
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList());
            }
            
            map.get(sortedStr).add(str);
        }
        
        List<List<String>> list = new ArrayList();
        for(String key: map.keySet()) {
            list.add(map.get(key));
        }
        
        return list;
    }
    
    private String getSortedString(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        
        return new String(sArr);
    }
}
