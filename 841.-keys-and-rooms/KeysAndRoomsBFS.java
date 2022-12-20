class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
      
        Set<Integer> visitedRooms = new HashSet();
        Queue<Integer> roomsToBeProcessed = new LinkedList();
      
        roomsToBeProcessed.add(0);
        visitedRooms.add(0);
        
        while(!roomsToBeProcessed.isEmpty()) {
            int currRoom = roomsToBeProcessed.poll();
            
            for(int nextRoom: rooms.get(currRoom)) {
                if(!visitedRooms.contains(nextRoom)) {
                    visitedRooms.add(nextRoom);
                    roomsToBeProcessed.add(nextRoom);
                }
            }
        }
        
        return (visitedRooms.size() == n);
    }
}
