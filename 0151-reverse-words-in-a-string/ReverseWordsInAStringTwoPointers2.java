class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = n-1;
        int firstWordBegins = 0;
        while(firstWordBegins < n && s.charAt(firstWordBegins) == ' ') firstWordBegins++;
        while(i >= 0) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                i--;
                continue;
            }
            
            int j = i;
            StringBuilder word = new StringBuilder();
            while(j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            int k = j+1;
            while(k <= i) {
                word.append(s.charAt(k));
                k++;
            }
            if(j+1 != firstWordBegins) word.append(" ");
            i = j;
            sb.append(word);
        }
      
        
        return sb.toString();
    }
}

/*
can use split and then reverse
eulb si yks eht
"  hello world  "
"  dlrow olleh  "
"a good   example"
"elpamaxe "
*/
