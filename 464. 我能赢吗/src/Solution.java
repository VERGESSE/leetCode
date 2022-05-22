class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;


        return dfs(0, desiredTotal, new Boolean[1 << maxChoosableInteger], maxChoosableInteger);
    }

    public boolean dfs(int state, int desiredTotal, Boolean[] dp, int maxChoosableInteger) {
        if (dp[state] != null) {
            return dp[state];
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int cur = 1 << (i - 1);
            if ((cur & state) != 0) {
                continue;
            }
            if (i >= desiredTotal || !dfs(cur | state, desiredTotal - i, dp, maxChoosableInteger)) {
                dp[state] = true;
                return true;
            }
        }
        dp[state] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canIWin(10, 40));
    }
}
