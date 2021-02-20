class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i : nums){
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        int[] contnums = new int[max - min + 1];

        int degree = 0;
        for(int i : nums){
            degree = Math.max(degree, ++contnums[i - min]);
        }
        if(degree == 1)   return 1;
        int result = nums.length;
        for (int i = 0; i < contnums.length; i++) {
            if(contnums[i] == degree){
                int tmp = min + i;
                int start = 0, end = nums.length - 1;
                while (start < end && nums[start] != tmp){
                    start++;
                }
                while (start < end && nums[end] != tmp){
                    end--;
                }
                result = Math.min(result, end - start + 1);
            }
        }
        return result;
    }
}

/* 慢
import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int degree = 0;
        List<Integer> maxTime = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > degree){
                degree = entry.getValue();
                maxTime.clear();
                maxTime.add(entry.getKey());
            } else if(entry.getValue() == degree){
                maxTime.add(entry.getKey());
            }
        }

        int max = 0;
        for(int maxNum : maxTime){
            int l = 0, r = len - 1;
            for(; l < len; l++){
                if(nums[l] == maxNum){
                    break;
                }
            }
            for(; r >= 0; r--){
                if(nums[r] == maxNum){
                    break;
                }
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}

 */
