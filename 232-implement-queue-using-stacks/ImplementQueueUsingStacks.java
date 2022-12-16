class MyQueue {
    Stack<Integer> elements, helper;
    public MyQueue() {
        elements = new Stack();
        helper = new Stack();
    }
    
    public void push(int x) {
        elements.push(x);
    }
    
    public int pop() {
        if(!helper.isEmpty()) return helper.pop();
        
        while(!elements.isEmpty()) {
            helper.push(elements.pop());
        }
        
        return helper.pop();
    }
    
    public int peek() {
        if(!helper.isEmpty()) return helper.peek();
        
        while(!elements.isEmpty()) {
            helper.push(elements.pop());
        }
        
        return helper.peek();
    }
    
    public boolean empty() {
        return helper.isEmpty() && elements.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
