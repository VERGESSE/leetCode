import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {

        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(
                new int[]{9,1,7,9,7,9,7}));
    }
}

/*
class Solution {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i += 3){
            if(nums[i] != nums[i+1])
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}
 */
