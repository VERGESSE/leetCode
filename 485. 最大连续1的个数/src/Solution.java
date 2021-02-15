class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int l = 0, r = 0;

        while(r < nums.length){
            if(nums[r] != 1){
                max = Math.max(max, r - l);
                r++;
                l = r;
                continue;
            }
            r++;
        }

        return Math.max(max, r - l);
    }
}
