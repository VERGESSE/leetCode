class Solution {
    public int findMagicIndex(int[] nums) {

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == i)
                return i;
            else if(nums[i] > i){
                i = nums[i] - 1;
            }
        }
        return -1;
    }
}
