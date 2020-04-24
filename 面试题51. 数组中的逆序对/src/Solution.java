class Solution {
    public int reversePairs(int[] nums) {

        int len = nums.length;
        if (len < 2) return 0;

        int[] temp = new int[len];
        return reversePairs(nums,0,len-1,temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {

        if (left == right) return 0;

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid+1])
            return leftPairs + rightPairs;

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    // 归并
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {

        for (int i = left; i <= right; i++)
            temp[i] = nums[i];

        int i = left;
        int j = mid + 1;
        int res = 0;
        for (int k = left; k <= right; ++k){

            if (i == mid + 1){
                nums[k] = temp[j];
                j++;
            }
            else if (j == right + 1){
                nums[k] = temp[i];
                i++;
            }
            else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                res += (mid - i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 5, 6, 4};
        int i = solution.reversePairs(nums);
        System.out.println(i);
    }
}