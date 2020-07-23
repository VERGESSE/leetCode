class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums== null || nums.length < 1)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int rigth = k - 1;
        int max = -1;
        while(rigth < nums.length){
            if(left > max){
                max = left;
                for(int i = left + 1; i <= rigth; i++){
                    max = nums[max] > nums[i] ? max : i;
                }
            } else {
                max = nums[max] > nums[rigth] ? max : rigth;
            }
            res[left] = nums[max];
            left++;
            rigth++;
        }
        return res;
    }
}

/* 暴力法
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums== null || nums.length < 1)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++){
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }

        return res;
    }
}*/
