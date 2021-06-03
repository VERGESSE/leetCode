import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        int n = nums.length;
        if(n < 2){
            return 0;
        }
        int sum = 0;
        int max  = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i++){
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxLength(
                new int[]{0,0,1,1,0,1,0}
                ));
    }
}
