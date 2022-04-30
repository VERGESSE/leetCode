class Solution {
    public int smallestRangeI(int[] nums, int k) {

        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if(max - min <= 2 * k){
            return 0;
        } else {
            return max - min - 2 * k;
        }
    }
}
