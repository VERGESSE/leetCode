class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];

        int index = len - 1;
        int[] memo = new int[len];
        memo[index] = nums[index];
        int res = nums[index];
        index--;
        while(index >= 0){
            if(memo[index+1] > 0){
                memo[index] = nums[index] + memo[index+1];
            } else  {
                memo[index] = nums[index];
            }
            index--;
        }

        for(int sum : memo)
            res = Math.max(res, sum);

        return res;
    }
}