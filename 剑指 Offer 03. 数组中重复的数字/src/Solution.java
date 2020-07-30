import java.util.Arrays;

class Solution {
    public int findRepeatNumber(int[] nums) {

        int n = nums.length;
        int[] memo = new int[n];
        for (int num : nums) {
            if (memo[num] != 0)
                return num;
            memo[num]++;
        }
        return nums[0];
    }
}

/*class Solution {
    public int findRepeatNumber(int[] nums) {

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1])
                return nums[i];
        }

        return nums[nums.length - 1];
    }
}*/
