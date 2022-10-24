class Solution {
    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0){
            return 0;
        }
        return maxLengthHelper(arr, 0, new int[26]);
    }
    
    private int maxLengthHelper(List<String> arr, int index, int[] seen) {
        if(index == arr.size()) {
            return 0;
        }
        
        int[] currSeen = seen.clone();
        String sequence = arr.get(index);
        boolean hasUnique = hasUniqueChars(sequence, currSeen);
        
        int includeCurr = 0;
        if(hasUnique) {
           includeCurr =  sequence.length() +  maxLengthHelper(arr, index+1, currSeen);
        }
        
        int excludeCurr = 0 + maxLengthHelper(arr, index+1, seen);
        
        return Math.max(includeCurr, excludeCurr);
    }
    
    private boolean hasUniqueChars(String sequence, int[] seen) {
        for(char ch: sequence.toCharArray()) {
            if(seen[ch - 'a'] == 1) {
                return false;
            }
            else {
                seen[ch - 'a']+=1;
            }
        }
        
        return true;
    }
}
