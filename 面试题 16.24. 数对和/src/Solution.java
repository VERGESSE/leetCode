import java.util.*;

class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {

        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while(l < r){
            int cur = nums[l] + nums[r];
            if(cur == target){
                res.add(List.of(nums[l], nums[r]));
                l++; r--;
            } else if(cur < target){
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
