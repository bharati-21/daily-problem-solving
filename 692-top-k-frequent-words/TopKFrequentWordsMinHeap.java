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

        PriorityQueue<Pair> pq = 
            new PriorityQueue<>(new CustomComparator());

        for(String word: map.keySet()) {
            int frequency = map.get(word);
            Pair p = new Pair(word, frequency);

            if(pq.size() < k) {
                pq.offer(p);
            }
            else {
                Pair root = pq.peek();
                if(root.frequency < frequency) {
                    pq.poll();
                    pq.offer(p);
                }
                else if(root.frequency == frequency && root.word.compareTo(word) > 0) {
                    pq.poll();
                    pq.offer(p);
                }
            }
        }

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            frequentWords.add(0,p.word);
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

        if(freqOne == freqTwo) {
            return wordTwo.compareTo(wordOne);
        }

        return freqOne - freqTwo;
    }
}

class Pair {
    String word;
    int frequency;
    Pair(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
