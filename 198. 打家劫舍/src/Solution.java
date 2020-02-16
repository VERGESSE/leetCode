class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;

        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(num+pre, cur);
            pre = tmp;
        }

        return cur;
    }
}

/*
class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;

        int[] memo = new int[n];
        memo[n-1] = nums[n-1];

        for (int i = n-2; i >= 0; i--){
            for (int j = i; j < n; j++){
                memo[i] = Math.max(memo[i],nums[j] + (j+2 < n ? memo[j+2] : 0));
            }
        }

        return memo[0];
    }
}
 */