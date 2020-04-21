import java.util.ArrayList;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int res = 0;
        int length = nums.length;

        int[] memo = new int[nums.length];
        int n = 0;
        for (int i = 0; i < length; i++) {
            if ((nums[i] & 1) == 1)
                memo[n++] = i;
        }

        if (n < k) return 0;

        for (int i = 0; i < n-k+1; i++){
            Integer index = memo[i + k - 1];
            int left  = memo[i];
            int right = length - index - 1;
            if (i != 0)
                left = left - memo[i-1] - 1;
            if (i+k < n)
                right = memo[i+k] - index - 1;

            if (left == 0)
                res += right+1;
            else if (right == 0)
                res += left+1;
            else
                res += (left+1)*(right+1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int i = solution.numberOfSubarrays(nums, 2);
        System.out.println(i);
    }
}