class Solution {
    public int numWays(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                next[dst] += dp[src];
            }
            dp = next;
        }
        return dp[n - 1];
    }
}

/* 广搜
class Solution {
    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }

        int steps = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edges.get(index);
                for (int nextIndex : list) {
                    queue.offer(nextIndex);
                }
            }
        }

        int ways = 0;
        if (steps == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == n - 1) {
                    ways++;
                }
            }
        }
        return ways;
    }
}
 */


/* 深搜
class Solution {
    int ways, n, k;
    List<List<Integer>> edges;

    public int numWays(int n, int[][] relation, int k) {
        ways = 0;
        this.n = n;
        this.k = k;
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        dfs(0, 0);
        return ways;
    }

    public void dfs(int index, int steps) {
        if (steps == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (int nextIndex : list) {
            dfs(nextIndex, steps + 1);
        }
    }
}
 */
