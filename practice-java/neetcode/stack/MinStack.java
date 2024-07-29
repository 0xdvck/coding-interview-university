import java.util.*;

class MinStack {
    // Two pointers
    // Time complexity: O(n)
    // Space complexity: O(n + k)
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();

    }

    public void push(int val) {
        this.stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
            this.minStack.push(val);
        }
    }

    public void pop() {
        int ele = this.stack.pop();
        
        if(!minStack.isEmpty() && ele == this.minStack.peek()) {
            this.minStack.pop();
        }
        
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return  this.minStack.peek();
    }
}