import java.util.*;

// 单调栈 + 循环数组
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = len * 2 - 1; i >= 0; i--){
            int cur = nums[i % len];
            while (!deque.isEmpty() && deque.peek() <= cur){
                deque.pop();
            }
            res[i % len] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(cur);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] elements = solution.nextGreaterElements(new int[]{5,4,3,2,1});
        for (int element : elements) {
            System.out.print(element + " ");
        }
    }
}

/* 双层循环遍历
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        for(int i = 0; i < len; i++){
            res[i] = foreach(nums, i);
        }

        return res;
    }

    private int foreach(int[] nums, int from){
        int len = nums.length;
        int index = from + 1 == len ? 0 : from + 1;
        while(index != from){
            if(nums[index] > nums[from]){
                return nums[index];
            }
            index ++;
            if(index == len){
                index = 0;
            }
        }
        return -1;
    }
}
 */
