class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            while(left < right && (nums[left] & 1) == 1 )
                left++;
            while(left < right && (nums[right] & 1) == 0)
                right--;
            swap(nums, left, right);
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
