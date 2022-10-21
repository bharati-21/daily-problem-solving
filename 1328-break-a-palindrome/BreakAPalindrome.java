class Solution {
	public String breakPalindrome(String palindrome) {
		if(palindrome == null || palindrome.length() == 0) {
			return palindrome;
        }

        int n = palindrome.length();
        if(n == 1) {
            return "";
        }
        
        int i = 0;
        while(i < n/2) {
            char ch = palindrome.charAt(i);
            if(ch != 'a') {
                return palindrome.substring(0,i) + 'a' + palindrome.substring(i+1);
            }
            i++;
        }
        
        return palindrome.substring(0,n-1) + 'b';
    }
}
