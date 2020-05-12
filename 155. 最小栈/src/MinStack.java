import java.util.*;

class MinStack {

    private LinkedList<Integer> array = new LinkedList<>();
    private Queue<Integer> queue = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        array.add(x);
        queue.add(x);
    }
    
    public void pop() {
        Integer remove = array.removeLast();
        queue.remove(remove);
    }
    
    public int top() {
        return array.getLast();
    }
    
    public int getMin() {
        return queue.peek();
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