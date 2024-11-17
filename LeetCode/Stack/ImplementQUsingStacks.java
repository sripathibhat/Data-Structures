class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        int size = s1.size();
        for (int i = 0; i < size - 1; i++) {
            s2.push(s1.pop());
        }
        int res = s1.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return res;
    }
    
    public int peek() {
        int size = s1.size();
        for (int i = 0; i < size; i++) {
            s2.push(s1.pop());
        }
        int res = s2.peek();
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return res;
    }
    
    public boolean empty() {
        return s1.isEmpty();
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
