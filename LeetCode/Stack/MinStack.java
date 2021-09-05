/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

*/

// Without extra space - O(1)
class MinStack {

    /** initialize your data structure here. */
    int minEle = 0;
    Stack<Long> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push((long)val);
            minEle = val;
        } else {
            if(minEle > val) {
                stack.push((long)2 * val - minEle);
                minEle = val;
            } else {
                stack.push((long)val);
            }
        }
    }
    
    public void pop() {
        if(stack.size() == 0) {
            return;
        }
        if(minEle > stack.peek()) {
            minEle = (int) (2 * minEle - stack.peek());
        }
        stack.pop();
    }
    
    public int top() {
        if(stack.peek() < minEle) {
            return minEle;
        }
        return (int)(long) (stack.peek());
    }
    
    public int getMin() {
        return minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// With extra space - supporting stack O(n)
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s;
    Stack<Integer> ss;
    public MinStack() {
        s = new Stack<Integer>();
        ss = new Stack<Integer>();
    }
    
    public void push(int x) {
        s.push(x);
        if (ss.isEmpty() || ss.peek() >= x) {
            ss.push(x);
        }
    }
    
    public void pop() {
        int x = s.pop();
        if (x == ss.peek()) {
            ss.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return ss.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */