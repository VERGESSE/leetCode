import java.util.*;

class MyQueue {

    private final Stack<Integer> satck1;
    private final Stack<Integer> satck2;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.satck1 = new Stack<>();
        this.satck2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        satck1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(satck2.isEmpty()){
            while(!satck1.isEmpty()){
                satck2.push(satck1.pop());
            }
        }
        return satck2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(satck2.isEmpty()){
            while(!satck1.isEmpty()){
                satck2.push(satck1.pop());
            }
        }
        return satck2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return satck1.isEmpty() && satck2.isEmpty();
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
