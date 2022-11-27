class Solution {
    public boolean check(int[] nums) {

        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (!flag) {
                    if (nums[nums.length - 1] > nums[0]) {
                        return false;
                    }
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
