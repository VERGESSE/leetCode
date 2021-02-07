class Solution {
    public boolean checkPossibility(int[] nums) {

        if(nums.length < 2){
            return true;
        }

        boolean flag = true;
        int index = 0;
        int maxIndex = nums.length - 1;

        while(index < maxIndex){
            if(nums[index] > nums[index + 1]){
                if(flag){
                    flag = false;
                    if (index > 0 && nums[index + 1] < nums[index - 1]) {
                        nums[index + 1] = nums[index];
                    }
                } else {
                    return false;
                }
            }
            ++ index;
        }

        return true;
    }
}
