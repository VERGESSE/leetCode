// 动态规划实现，较慢
class Solution {
    public int jump(int[] nums) {

        int len = nums.length;
        if(len <= 1) return 0;

        int[] memo = new int[len];
        memo[len - 1] = 0;
        int index = len - 2;

        while(index >= 0){
            int tempR = index + nums[index];
            int r = tempR < len ? tempR : len - 1;
            int n = Integer.MAX_VALUE - 1;
            int i = index;
            while(++i <= r){
                n = Math.min(n, memo[i] + 1);
            }
            memo[index--] = n;
        }

        return memo[0];
    }
}

// 贪心
/*
class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
 */