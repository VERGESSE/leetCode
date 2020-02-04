import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Map<Integer,List<Integer>> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            List<Integer> list = numMap.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            numMap.put(nums[i],list);
        }

        Set<Map.Entry<Integer, List<Integer>>> entries = numMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            Integer key = entry.getKey();
        }
    }
}