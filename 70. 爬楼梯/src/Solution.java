import java.util.Arrays;

class Solution {

    // 动态规划
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);

        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}

/*  记忆化搜索
class Solution {

    int[] memo;

    public int climbStairs(int n) {

        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return calcWays(n);
    }

    private int calcWays(int n) {

        if (n == 0 || n ==1)
            return 1;

        if (memo[n] == -1)
            memo[n] = calcWays(n-1) + calcWays(n-2);

        return memo[n];
    }
}
 */