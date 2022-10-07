class MyCalendarThree {
    // We want sorted intervals. That is the smallest point of all booking [start, end)
    // must appear first
    // If we were to book 2 ranges [50,60], [10,20] => this will sort the ranges
    // 10, 20, 50, 60
    TreeMap<Integer, Integer> events;
    
    public MyCalendarThree() {
        events = new TreeMap();
    }
    
    public int book(int start, int end) {
        // Increment the count of start by 1
        events.put(start, events.getOrDefault(start,0)+1);
        // Decrement the count of end by 1
        events.put(end, events.getOrDefault(end,0)-1);
        
        // Get the max bookings so far with current and previous events.
        int maxBooking = 0, currBooking = 0;
        for(int booking: events.values()) {
            currBooking += booking;
            // If the value is greater than the previous maxBookings, update
            maxBooking = Math.max(maxBooking, currBooking);
        }
        
        return maxBooking;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
