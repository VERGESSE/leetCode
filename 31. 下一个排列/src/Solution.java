class Solution {
    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length <=1)
            return;
        int left = 0, right = nums.length - 1;
        while(right > left){
            // 从右向左找到第一个降序索引
            if(nums[right] <= nums[right - 1]){
                right--;
                continue;
            }
            int min = right - 1;
            int max = right;
            // 找到出现降序的索引min后面的比min值大的最小索引
            while(right < nums.length){
                // 如果遇到min后面有重复的max值，取下标最大的，保证min后数组降序排序
                if(nums[max] >= nums[right] && nums[right] > nums[min])
                    max = right;
                right++;
            }
            int t = nums[max];
            nums[max] = nums[min];
            nums[min] = t;
            // 对min后升序的数组改为降序
            left = min + 1;
            break;
        }
        right = nums.length - 1;
        // 翻转数组
        while(right > left){
            int t = nums[right];
            nums[right] = nums[left];
            nums[left] = t;
            right--;
            left++;
        }
    }
}
