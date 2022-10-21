class Pair {
    String word;
    int frequency;
    Pair(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}

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

        List<Pair> sortedPairs = new ArrayList();
        for(String word: map.keySet()) {
            int frequency = map.get(word);
            sortedPairs.add(new Pair(word, frequency));
        }

        Collections.sort(sortedPairs, new CustomComparator());

        for(int i = 0; i<k; i++) {
            Pair p = sortedPairs.get(i);
            String word = p.word;
            frequentWords.add(word);
        }


        return frequentWords;
    }
}

class CustomComparator implements Comparator<Pair> {
    public int compare(Pair pOne, Pair pTwo) {
        int freqOne = pOne.frequency;
        int freqTwo = pTwo.frequency;

        String wordOne = pOne.word;
        String wordTwo = pTwo.word;

        // If frequencies are the same, we return the smaller string
        if(freqOne == freqTwo) {
            return wordOne.compareTo(wordTwo);
        }

        // else we return the string with a greater frequency
        return freqTwo - freqOne;
    }
}
