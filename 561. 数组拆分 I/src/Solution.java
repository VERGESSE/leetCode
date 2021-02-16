import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;

        for(int i = 0; i < len; i += 2){
            sum += nums[i];
        }

        return sum;
    }
}
