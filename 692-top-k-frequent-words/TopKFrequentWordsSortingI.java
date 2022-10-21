class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> frequentWords = new ArrayList();


        HashMap<String, Integer> map = new HashMap();
        if(words == null || words.length == 0) {
            return frequentWords;
        }

        int mostFreq = 0;
        for(String word: words) {
            if(!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word)+1);
            mostFreq = Math.max(mostFreq, map.get(word));
        }

        Arrays.sort(words);

        // This is needed to ensure that we don't add duplicate words
        // that appear multiple times in the word
        String prevWord = "";

        while(mostFreq > 0 && frequentWords.size() < k) {
            for(String word: words) {
                if(map.get(word) == mostFreq && 
                   !prevWord.equals(word)) {
                    frequentWords.add(word);
                    prevWord = word;
                    if(frequentWords.size() == k) {
                        break;
                    }
                }
            }
            mostFreq--;
        }

        return frequentWords;
    }
}
