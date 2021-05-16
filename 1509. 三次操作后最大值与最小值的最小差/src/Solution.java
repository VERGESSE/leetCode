import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {

        int n = nums.length;
        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, nums[n - 4 + i] - nums[i]);
        }
        return ret;
    }
}
