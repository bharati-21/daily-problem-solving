class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] matchCount = new int[100001];
        Arrays.fill(matchCount, -1);
        
        for(int[] match: matches) {
            int winner = match[0];
            int loser = match[1];

            int winnerCount = matchCount[winner];
            if(winnerCount == -1) {
                matchCount[winner] = 0;
            }
            
            int loserCount = matchCount[loser];
            matchCount[loser] += (loserCount == -1) ? 2 : 1;
        }
        
        List<Integer> winners = new ArrayList();
        List<Integer> losers = new ArrayList();
        
        for(int player = 1; player <= 100000; player++) {
            int count = matchCount[player];
            
            if(count == 0) {
                winners.add(player);
            }
            else if(count == 1) {
                losers.add(player);
            }
        }
        
        List<List<Integer>> answer = new ArrayList();
        
        answer.add(winners);
        answer.add(losers);
        
        return answer;
    }
}
