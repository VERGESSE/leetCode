import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] memo = new int[nums.length];
        Arrays.fill(memo,1);

        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    memo[i] = Math.max(memo[i], 1+memo[j]);

        int res = 1;
        for (int i = 0; i < nums.length; i++)
            res = Math.max(res,memo[i]);

        return res;
    }
}