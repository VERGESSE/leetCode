class Solution {

    int[] coins = {1,5,10,25};
    int[] dp;

    public int waysToChange(int n) {

        dp = new int[n+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; ++i){
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToChange(10));
    }
}

/*   数学
class Solution {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int ans = 0;
        for (int i = 0; i <= n / 25; i++) {
            long tmp = (n - i * 25) / 10;
            ans = (int)((ans + (tmp + 1) * (n / 5 - i * 5 + 1 - tmp)) % mod);
        }
        return ans;
    }
}
 */