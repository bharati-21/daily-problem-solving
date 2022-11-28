class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap();
        
        for(int[] match: matches) {
            int winner = match[0];
            int loser = match[1];
            
            if(!lossCount.containsKey(loser)) {
                lossCount.put(loser, 0);
            }
            int count = lossCount.get(loser);
            lossCount.put(loser, count + 1);
            
            if(!lossCount.containsKey(winner)) {
                lossCount.put(winner, 0);
            }
        }
        
        List<List<Integer>> answer = new ArrayList();
        List<Integer> winners = new ArrayList(), losers = new ArrayList();
        
        for(int player: lossCount.keySet()) {
            if(lossCount.get(player) == 0) {
                winners.add(player);
            }
            else if(lossCount.get(player) == 1) {
                losers.add(player);
            }
        }
        
        Collections.sort(winners);
        Collections.sort(losers);
        
        answer.add(winners);
        answer.add(losers);
        
        return answer;
    }
}
