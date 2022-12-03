class Solution {
    private int n;
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";
        
        n = s.length();
        
        // get frequency of every character
        Map<Character, Integer> frequency = new HashMap();
        findFrequencyOfCharacters(s, frequency);
        
        // build a max heap with character frequencies
        PriorityQueue<Pair<Integer, Character>> pq = new     
            PriorityQueue<>(
                (a,b) -> b.getKey() - a.getKey()
            );
        heapify(frequency, pq);
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair<Integer, Character> pair = pq.poll();
            int count = pair.getKey();
            char ch = pair.getValue();
            while(count-- != 0) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
    
    private void heapify(Map<Character, Integer> frequency, 
                         PriorityQueue<Pair<Integer, Character>> pq) {
        for(char ch: frequency.keySet()) {
            Pair pair = new Pair(frequency.get(ch), ch);
            pq.add(pair);
        }
    }
    
    private void findFrequencyOfCharacters(String s,
                        Map<Character, Integer> frequency) {
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            frequency.put(ch, 
                          frequency.getOrDefault(ch, 0) + 1);
        }
    }
}
