class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int sum = 0;
        int min = 0;
        int max = nums[0];
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}

/*
class Solution {
    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] memo = new int[len];
        memo[0] = nums[0];
        for(int i = 1; i < len ;i++){
            if(memo[i - 1] > 0){
                memo[i] = nums[i] + memo[i-1];
            } else{
                memo[i] = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int cur : memo){
            max = Math.max(max, cur);
        }
        return max;
    }
}
*/
