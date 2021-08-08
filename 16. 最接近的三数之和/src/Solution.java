import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int cur = nums[i] + nums[l] + nums[r];
                int dev = cur - target;
                if(dev < 0 ){
                    l++;
                } else if(dev > 0) {
                    r--;
                } else {
                    return cur;
                }
                if(Math.abs(res) > Math.abs(dev)) {
                    res = dev;
                }
            }
        }
        return target + res;
    }
}
