class Solution {
    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0){
            return 0;
        }
                
        return maxLengthHelper(arr, 0, new StringBuilder(""));
    }
    
    private int maxLengthHelper(List<String> arr, int index, StringBuilder sb) {
        if(index == arr.size()) {
            return sb.length();
        }
        
        String subsequence = arr.get(index);
                
        // If we can combine the current subsequence with the previous string
        boolean hasUniqueChars = hasUnique(sb.toString() + subsequence);
            
        int includeCurr = 0;
        if(hasUniqueChars) {
            includeCurr =  maxLengthHelper(arr, index+1, sb.append(subsequence));
            
            int n = sb.length();
            int m = subsequence.length();
            sb = sb.delete(n-m, n);
        }
                
        int excludeCurr = maxLengthHelper(arr, index+1, sb);
        
        return Math.max(includeCurr, excludeCurr);
    }
    
    private boolean hasUnique(String s) {
        int[] seen = new int[26];
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(seen[c - 'a'] == 1) {
                return false;
            }
            seen[c - 'a']++;
        }
        
        return true;
    }
}
