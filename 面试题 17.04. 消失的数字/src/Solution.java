class Solution {
    public int missingNumber(int[] nums) {

        boolean[] contains = new boolean[nums.length+1];

        for(int i : nums){
            contains[i] = true;
        }

        for(int i = 0; i < contains.length; i++){
            if(!contains[i]){
                return i;
            }
        }
        return -1;
    }
}

/* 神奇的异或
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        return res;
    }
}
 */
