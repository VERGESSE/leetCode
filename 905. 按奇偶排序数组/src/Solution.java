class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int l = 0, r = nums.length - 1;

        while(l < r){
            while(nums[l] % 2 == 0 && l < nums.length - 1){
                l++;
            }
            while(nums[r] % 2 == 1 && r > 0){
                r--;
            }
            if(nums[l] % 2 == 1 && nums[r] % 2 == 0 && l < r){
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l ++; r --;
            }
        }

        return nums;
    }
}
