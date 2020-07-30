import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    private Queue<Integer> A, B;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 小顶堆,存放中位数到最大元素
        this.A = new PriorityQueue<>();
        // 大顶堆,存放最小元素到中位数
        this.B = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        // 如果A的size等于B的size,则应该往A添加元素
        // 添加的元素为B和num之中最大的值,保证A中存放大的一半值
        if (A.size() == B.size()){
            B.add(num);
            A.add(B.poll());
        } else {
            // 同理AB的size相等,往B添加元素需要保证新元素为A和num之中最小的数
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        if (A.size() == 0)
            return 0;
        return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0: A.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
