import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.offerLast(x);
        if (min.size() == 0)
            min.offerLast(x);
        else if (x <= min.peekLast())
            min.offerLast(x);
    }

    public void pop() {
        Integer pop = stack.pollLast();
        if (Objects.equals(pop, min.peekLast()))
            min.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return min.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

/* 这是个高手
class MinStack {
    private MyNode node;
    public MinStack() {

    }

    public void push(int x) {
        if(node==null){
            node=new MyNode(x,x,null);
        }
        else{
            node = new MyNode(x, Math.min(node.min, x), node);
        }
    }

    public void pop() {
        node=node.next;
    }

    public int top() {
        return node.val;
    }

    public int min() {
        return node.min;
    }
}

class MyNode{
    int val;
    int min;
    MyNode next;
    MyNode(int val,int min,MyNode next){
        this.val=val;
        this.min=min;
        this.next=next;
    }

}
 */
