import java.util.*;

class Solution {
    public void duplicateZeros(int[] arr) {

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++) {
            if (!deque.isEmpty()){
                deque.offer(arr[i]);
                arr[i] = deque.remove();
            }
            if (arr[i] == 0 && i < arr.length - 1){
                deque.offer(arr[i + 1]);
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }
}
