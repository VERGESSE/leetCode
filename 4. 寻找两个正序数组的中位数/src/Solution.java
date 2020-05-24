class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 确保nums1是短的那个数组
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        int totalLeft = len1 + (len2 - len1 + 1) / 2;

        // 在nums1中查找适当地分割线
        // 使得 nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        int left = 0, right = len1;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == len1 ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == len2 ? Integer.MAX_VALUE : nums2[j];

        if (((len1 + len2) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) +
                    Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
