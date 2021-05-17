class Solution {
    public int minIncrementForUnique(int[] nums) {
        int sum = 0, max = 0;
        int aLength = nums.length;
        for (int aA : nums) {
            max = Math.max(max, aA);
        }

        int[] B = new int[2 * aLength];
        for (int aA : nums) {
            B[aA]++;
        }
        for (int i = 0; i < B.length; i++){

            if(B[i] > 1){
                B[i + 1] += B[i] - 1;
                sum += B[i] - 1;
            }
        }
        return sum;
    }
}

/* 排序
import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, taken = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                taken++;
                ans -= nums[i];
            } else {
                int give = Math.min(taken, nums[i] - nums[i - 1] - 1);
                ans += give * (give + 1) / 2 + give * nums[i - 1];
                taken -= give;
            }
        }

        if (nums.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * nums[nums.length - 1];
        }

        return ans;
    }
}

 */
