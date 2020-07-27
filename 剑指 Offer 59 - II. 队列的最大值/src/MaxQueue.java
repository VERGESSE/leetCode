import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MaxQueue {

    private Queue<Integer> queue;
    private LinkedList<Integer> max;
    public MaxQueue() {
        queue = new LinkedList<>();
        //LinkedList是双端链表
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.size() == 0 ? -1 : max.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        //注意：这里第二个判断条件不能带等号，即max中对于当前queue中的具有相同值的元素会全部存储，而不是存储最近的那个。
        while(max.size() != 0 && max.getLast() < value){
            max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        //Integer类型的值的比较不能直接使用==
        if(max.size() != 0 && Objects.equals(queue.peek(), max.getFirst()))
            max.removeFirst();
        return queue.size() == 0 ? -1 : queue.poll();
    }

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
}
