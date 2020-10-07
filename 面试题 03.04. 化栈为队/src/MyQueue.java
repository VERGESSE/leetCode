import java.util.*;

class MyQueue {

    private Stack<Integer> main;
    private Stack<Integer> sub;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.main = new Stack<>();
        this.sub = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        main.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!sub.isEmpty()){
            return sub.pop();
        } else {
            reverseStack();
            return sub.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!sub.isEmpty()){
            return sub.peek();
        } else {
            reverseStack();
            return sub.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return main.isEmpty() && sub.isEmpty();
    }

    private void reverseStack(){
        while(!main.isEmpty()){
            sub.push(main.pop());
        }
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
