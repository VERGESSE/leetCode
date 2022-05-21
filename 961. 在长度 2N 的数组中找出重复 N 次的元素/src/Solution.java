class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 3; i++){
            if(nums[i] == nums[i + 1] || nums[i] == nums[i + 2] || nums[i] == nums[i + 3]){
                return nums[i];
            }
            if(nums[i + 1] == nums[i + 2] || nums[i + 1] == nums[i + 3]){
                return nums[i + 1];
            }
            if(nums[i + 2] == nums[i + 3]){
                return nums[i + 2];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedNTimes(new int[]{1,2,3,3}));
    }
}
