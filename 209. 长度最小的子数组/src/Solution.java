class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        int l = 0,r = -1;
        int res = nums.length + 1;
        int sum = 0;

        while (l < nums.length){

            if( r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else
                sum -= nums[l++];

            if(sum >= s){
                res = Math.min(res, r - l + 1);
            }
        }

        if( res == nums.length + 1){
            res = 0;
        }

        return res;
    }
}