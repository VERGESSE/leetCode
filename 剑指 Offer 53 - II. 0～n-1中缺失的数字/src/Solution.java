class Solution {
    public int missingNumber(int[] nums) {

        if(nums == null || nums.length == 0 || nums[0] != 0)
            return 0;
        int n = nums.length;

        for(int i = 1; i < n; i++){
            if(nums[i] != i)
                return i;
        }

        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution
            .missingNumber(new int[]{0,1,2,3,4,5,6,7,8}));
    }
}
