class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 0) {
            return s;
        }
        
        if(k == 1) {
            String ans = s;
            int n = s.length();
            
            for(int i = 1; i<n; i++) {
                String moveFirstToBack = s.substring(i) + s.substring(0,i);
                if(moveFirstToBack.compareTo(ans) < 0) {
                    ans = moveFirstToBack;
                }
                
                /*
                cbaf
                i = 1
                bafc
                
                i = 2
                afcb
                
                i = 3
                bafc
                */
            }
            
            return ans;
        }
        
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        
        return new String(sArr);
    }
}

/*
baaca

aacab
    acaba
    acaba
    aaabc
bacaa
    a
bacaa


// 2a

*/
