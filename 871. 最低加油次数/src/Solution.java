import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int t, int start, int[][] ss) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        int n = ss.length, idx = 0;
        int remain = start, loc = 0, ans = 0;
        while (loc < t) {
            if (remain == 0) {
                if (!q.isEmpty() && ++ans >= 0) remain += q.poll();
                else return -1;
            }
            loc += remain; remain = 0;
            while (idx < n && ss[idx][0] <= loc) q.add(ss[idx++][1]);
        }
        return ans;
    }
}

/* 动态规划 n2
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}
 */
