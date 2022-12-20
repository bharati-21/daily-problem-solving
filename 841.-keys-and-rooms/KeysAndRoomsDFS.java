class Solution {
    private int n;
    private boolean[] visitedRooms;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        visitedRooms = new boolean[n];
        
        traverseRooms(rooms, 0);
        
        for(boolean isVisited: visitedRooms) {
            if(!isVisited) return false;
        }
        
        return true;
    }
    
    private void traverseRooms(List<List<Integer>> rooms, int room) {
        visitedRooms[room] = true;
        
        for(int nextRoom: rooms.get(room)) {
            if(!visitedRooms[nextRoom]) {
                traverseRooms(rooms, nextRoom);
            }
        }
    }
}
