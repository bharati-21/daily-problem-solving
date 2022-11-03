class Solution {
    public int longestPalindrome(String[] words) {
        int n = words.length;
        
        Map<String, Integer> frequency = getWordsFrequency(words);
        
        int count = 0;
        boolean hasDoubleOccurring = false;
        
        for(String word: words) {
            char first = word.charAt(0), second = word.charAt(1);
            String reversed = "" + second + first;
            
            if(frequency.containsKey(reversed)) {
                int wordFreq = frequency.get(word);

                if(first == second) {
                    if(wordFreq > 1) {
                        count += 4;
                        wordFreq -= 2;
                        if(wordFreq == 0) {
                            frequency.remove(word);
                        }
                        else {
                            frequency.put(word, wordFreq);
                        }
                    }
                    else if(!hasDoubleOccurring) {
                        // only decrement once
                        count += 2;
                        wordFreq -= 1;
                        hasDoubleOccurring = true;
                        if(wordFreq == 0) {
                            frequency.remove(word);
                        }
                        else {
                            frequency.put(word, wordFreq);
                        }
                    }  
                }
                else {
                    int revFreq = frequency.get(reversed);
                    revFreq-=1;
                    wordFreq -= 1;
                    count += 4;
                    if(revFreq == 0 || wordFreq == 0) {
                        frequency.remove(reversed);
                        frequency.remove(word);
                    }
                    else {
                        frequency.put(reversed, revFreq);
                        frequency.put(word, wordFreq);
                    }
                }
                
                
            }
        }
        return count;
    }
    
    private Map<String, Integer> getWordsFrequency(String[] words) {
        Map<String, Integer> frequency = new HashMap();
        for(String word: words) {
            if(!frequency.containsKey(word)) {
                frequency.put(word, 1);
            }
            else {
                frequency.put(word, frequency.get(word)+1);
            }
        }
        
        return frequency;
    }
}


/*
If all are repeating chars
If I pick up a word-
- If a word has repearing chars pick it, also find if it has matching string with the same repeating chars
- If a word does not have repeating characters pick it iff there is another set with reversed char 
*/


/*
["aa","bb", "dd","cc"]
"dd
 dd
 aa
 aa
 bb
 bb
 dd
 dd
 cc
 cc"

["em","pe","mp","ee","pp","me","ep","em","em","me"]

"em" "me" (3,2) -> 4
"pe" "ep" (1,1) -> 4
"ee" (1,1) -> 2
"me" "em" (1, 2) -> 4
"ep" ""

*/
