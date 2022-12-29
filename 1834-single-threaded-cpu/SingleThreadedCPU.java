class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        /*
            We cannot sort the array as original ordering is required
            Create a new array -- tasksByEnqueue with 
            tasksByEnqueue[i] = [enqueueTime, processingTime, index]
        */
        int[][] tasksByEnqueue = new int[n][3];
        for(int i = 0; i<n; i++) {
            int[] task = tasks[i];
            
            tasksByEnqueue[i] = new int[] {
                task[0], task[1], i
            };
        }
        
        // Sort tasksByEnqueue by enqueueTime
        Arrays.sort(tasksByEnqueue, (a,b) -> a[0] - b[0]);
        
        // To keep track of all the scheduled tasks 
        // such that enqueueTime <= currTime
        PriorityQueue<int[]> scheduledTasks = new PriorityQueue<int[]>
        (
            (a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]
        );
        
        // index -- represents index of the next smallest task
        // currTime -- current CPU time
        // order -- represents order of tasks processed
        int index = 0, currTime = tasksByEnqueue[index][0];
        
        int[] order = new int[n];
        int orderIndex = 0;
        
        while(orderIndex < n) {
            // Schedule all tasks with enqueueTime <= currTime
            while(index < n && tasksByEnqueue[index][0] <= currTime) {
                scheduledTasks.add(tasksByEnqueue[index]);
                index++;
            }
            
            // If any scheduled task, poll and process it
            // add the polled task index to the order 
            // update currTime with the polled task's processTime
            if(!scheduledTasks.isEmpty()) {
                int[] currTask = scheduledTasks.poll();
                int processTime = currTask[1];
                int taskIndex = currTask[2];
                order[orderIndex++] = taskIndex;
                currTime += processTime;
                continue;
            }
            // If no task scheduled, update currTime to task with
            // next smallest enqueueTime
            else {
                currTime = tasksByEnqueue[index][0];
            }
        }
        
        return order;
    }
}
