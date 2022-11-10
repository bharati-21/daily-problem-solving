class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        char[] arr = s.toCharArray();
        
        int nonDupIndex = 0;
        int i = 0;
        
        while(i < n) {
            arr[nonDupIndex] = arr[i];
            if(nonDupIndex > 0) {
                if(arr[nonDupIndex - 1] == arr[nonDupIndex]) {
                    nonDupIndex -= 2;
                }
            }
            i++;
            nonDupIndex++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < nonDupIndex; j++) {
            sb.append(arr[j]);
        }
        
        return sb.toString();
    }
}
