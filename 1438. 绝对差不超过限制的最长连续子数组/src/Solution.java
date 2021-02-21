class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int len = nums.length;
        if(len <= 1){
            return len;
        }

        int res = 0;
        int l = 0, r = 0;
        int min = nums[l];
        int max = nums[l];

        while(++r < len){
            min = Math.min(min, nums[r]);
            max = Math.max(max, nums[r]);
            if(max - min > limit){
                res = Math.max(res, r - l);
                min = nums[r];
                max = nums[r];
                l = r - 1;
                while (Math.abs(nums[l] - nums[r]) <= limit){
                    min = Math.min(min, nums[l]);
                    max = Math.max(max, nums[l]);
                    l--;
                }
                l++;
            }
        }
        res = Math.max(res, r - l);

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(
                new int[]{10,1,2,4,7,2},
                5
        ));
    }
}
