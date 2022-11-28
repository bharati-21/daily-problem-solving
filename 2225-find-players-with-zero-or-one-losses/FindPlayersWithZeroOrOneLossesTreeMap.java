class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> countWinsByPlayer = new TreeMap<>();
        Map<Integer, Integer> countLossByPlayer = new TreeMap<>();
        
        for(int[] match: matches) {
            int winner = match[0];
            int loser = match[1];
            
            if(!countWinsByPlayer.containsKey(winner)) {
                countWinsByPlayer.put(winner, 0);
            }
            int winCount = countWinsByPlayer.get(winner);
            countWinsByPlayer.put(winner, winCount + 1);
            
            if(!countLossByPlayer.containsKey(loser)) {
                countLossByPlayer.put(loser, 0);
            }
            int loseCount = countLossByPlayer.get(loser);
            countLossByPlayer.put(loser, loseCount + 1);
        }
        
        List<List<Integer>> answer = new ArrayList();
        answer.add(new ArrayList());
        answer.add(new ArrayList());
        for(int winner: countWinsByPlayer.keySet()) {
            if(!countLossByPlayer.containsKey(winner)) {
                answer.get(0).add(winner);
            }
        }
        
        for(int loser: countLossByPlayer.keySet()) {
            if(countLossByPlayer.get(loser) == 1) {
                answer.get(1).add(loser);
            }
        }
        
        return answer;
    }
}
