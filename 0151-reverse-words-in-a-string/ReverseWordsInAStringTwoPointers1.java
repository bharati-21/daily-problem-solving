class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                i++;
                continue;
            }
            
            int j = i;
            StringBuilder word = new StringBuilder();
            while(j < n && s.charAt(j) != ' ') {
                word.append(s.charAt(j));
                j++;
            }
            if(!sb.isEmpty()) word.append(" ");
            i = j;
            sb.insert(0, word);
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
