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