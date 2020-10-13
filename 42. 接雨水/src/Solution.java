class Solution {
    public int trap(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }
        int sum = 0;

        //left[i]表示第i列左边的最高的列值,包含
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = left[i - 1] > height[i] ? left[i - 1] : height[i];
        }

        int[] right = new int[height.length];
        right[height.length - 1] = height[right.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] > height[i] ? right[i + 1] : height[i];
        }

        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}

/* 双指针
public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= left_max) {
                left_max = height[left];
            } else {
                ans += (left_max - height[left]);
            }
            ++left;
        } else {
            if (height[right] >= right_max) {
                right_max = height[right];
            } else {
                ans += (right_max - height[right]);
            }
            --right;
        }
    }
    return ans;
}
 */
