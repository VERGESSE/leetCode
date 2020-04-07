class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];

        int m = 0;
        while (dp[K][m] < N){
            m++;
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1;
        }

        return m;
    }
}

/*
题解
https://leetcode-cn.com/problems/super-egg-drop/solution/ji-ben-dong-tai-gui-hua-jie-fa-by-labuladong/
 */