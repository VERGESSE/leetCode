class Solution {
    public void sortColors(int[] nums) {

        int zero = -1;
        int two = nums.length;
        int temp;
        for(int i = 0; i < two; ){
            if(nums[i] == 2){
                temp = nums[--two];
                nums[two] = nums[i];
                nums[i] = temp;
            }else if(nums[i] == 0){
                temp = nums[i];
                nums[i++] = nums[++zero];
                nums[zero] = temp;
            }else if(nums[i] == 1){
                i++;
            }
        }
    }
}