





class Solution {
    public int removeElement(int[] nums, int val) {

        int k = 0;
        int temp;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val)
                if (i != k){
                    temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = nums[k];
                    k++;
                }else {
                    k++;
                }
        }
        return k;
    }
}