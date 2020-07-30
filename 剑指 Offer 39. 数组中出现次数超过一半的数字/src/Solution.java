import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

/*class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}*/
