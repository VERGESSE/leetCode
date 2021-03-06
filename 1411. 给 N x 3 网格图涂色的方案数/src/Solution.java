// 题解：
// https://leetcode-cn.com/problems/number-of-ways-to-paint-n-3-grid/solution/shu-xue-jie-jue-fei-chang-kuai-le-by-lindsaywong/
class Solution {
    private static final int MOD = 1000000007;

    public int numOfWays(int n) {
        long fi0 = 6, fi1 = 6;
        for (int i = 2; i <= n; ++i) {
            long newFi0 = (2 * fi0 + 2 * fi1) % MOD;
            long newFi1 = (2 * fi0 + 3 * fi1) % MOD;
            fi0 = newFi0;
            fi1 = newFi1;
        }
        return (int) ((fi0 + fi1) % MOD);
    }
}
