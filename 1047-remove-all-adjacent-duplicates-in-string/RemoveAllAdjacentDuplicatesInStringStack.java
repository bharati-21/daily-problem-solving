class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            
            if(!stack.isEmpty()) {
                char top = stack.peek();
                
                if(top == ch) {
                    stack.pop();
                    continue;
                }
            }
            
            stack.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch: stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
