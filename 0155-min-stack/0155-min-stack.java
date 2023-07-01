class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> st;
    static int min;
    public MinStack() { 
        st = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min); 
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
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