import java.util.*;

class Solution {
    class Pair{
        Integer num;
        Integer index;
        Pair(Integer num,Integer index){
            this.num = num;
            this.index = index;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> ret = new LinkedList<>();

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.index>o2.index) return 1;
                else if (o1.index<o2.index) return -1;
                else return 0;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Pair(entry.getKey(),entry.getValue()));
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }

        for (int i = 0; i < k; i++){
            ((LinkedList)ret).addFirst(priorityQueue.remove().num);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        Solution solution = new Solution();
        List<Integer> integers = solution.topKFrequent(nums,2);
        System.out.println(integers);
    }
}
