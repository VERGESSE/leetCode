import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }

        int longset = 0;

        for(int num : set){
            if(!set.contains(num - 1)){
                int length = 1;
                while(set.contains(num + 1)){
                    num++;
                    length++;
                }
                longset = Math.max(longset, length);
            }
        }

        return longset;
    }
}
