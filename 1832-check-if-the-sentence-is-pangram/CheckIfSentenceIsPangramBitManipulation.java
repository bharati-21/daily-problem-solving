class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence == null || sentence.length() == 0) {
            return false;
        }

        int mask = 0;
        int n = sentence.length();
        for(int i = 0; i<n; i++) {
            char ch = sentence.charAt(i);

            int maskNumber = ch-'a';
            mask |= 1 << maskNumber;
        }
        int test = (1<<26) - 1;
        return (mask & test) == test;
    }
}
