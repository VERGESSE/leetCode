class Solution {
    public int[] twoSum(int[] nums, int target) {
        int max = 2047;
        int[] test = new int[max+1];
        for(int i = 0;i<nums.length;i++){
            int temp = target-nums[i];
            int pos = test[temp & max];
            if (pos!=0)
            {
                return new int[]{pos-1,i};
            }
            test[nums[i]&max] = i + 1;
        }
        return null;
    }
}