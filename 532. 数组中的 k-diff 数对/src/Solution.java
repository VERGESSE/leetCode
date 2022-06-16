import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;

        for(int i = 0; i < nums.length - 1; i++){
            int pre = i;
            while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                i++;
            }
            if(k == 0 && pre != i){
                res++;
            }
            for(int j = i + 1; j < nums.length; j++){
                int diff = Math.abs(nums[j] - nums[i]);
                if(diff >= k){
                    if(diff == k){
                        res++;
                    }
                    break;
                }
            }
        }

        return res;
    }
}
