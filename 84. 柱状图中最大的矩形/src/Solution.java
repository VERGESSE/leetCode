import java.util.Stack;

// 单调栈
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? len : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < len; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}

/* 暴力解法
class Solution {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int height = Integer.MAX_VALUE;
        int maxArea = 0;

        for (int i = 0; i < len; i++){
            for (int j = i; j < len; j++){
                height = Math.min(height, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * height);
            }
            height = Integer.MAX_VALUE;
        }

        return maxArea;
    }
}
 */