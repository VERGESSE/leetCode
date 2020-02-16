import java.util.Arrays;

class Solution {
    public int combinationSum4(int[] nums, int target) {

        if (nums.length == 0 || target == 0)
            return 0;

        Arrays.sort(nums);

        int[] memo = new int[target+1];
        memo[0] = 1;

        for (int i = 1; i <= target; i++){
            for (int j = 0; j < nums.length; j++){
                if (i - nums[j] >= 0)
                    memo[i] = memo[i] + memo[i - nums[j]];
                else break;
            }
        }

        return memo[target];
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3};
        System.out.println(new Solution().combinationSum4(ints,4));
    }
}