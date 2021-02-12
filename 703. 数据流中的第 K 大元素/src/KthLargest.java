import java.util.PriorityQueue;

class KthLargest {

    private final PriorityQueue<Integer> queue;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k) ;
        for(int i = 0; i < k && i < nums.length; i++){
            queue.add(nums[i]);
        }
        while (k < nums.length){
            if (queue.isEmpty() || queue.peek() <  nums[k]){
                queue.poll();
                queue.add(nums[k]);
            }
            k++;
        }
    }

    public int add(int val) {
        if (queue.size() < k){
            queue.add(val);
            return queue.peek();
        }
        if (queue.peek() < val){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
