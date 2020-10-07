import java.util.*;

class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

        if (target >= n)
            return false;
        boolean[] memo = new boolean[n];
        HashMap<Integer, HashSet<Integer>> graph0 = new HashMap<>();
        // 构造邻接矩阵
        for (int[] g : graph) {
            HashSet<Integer> set = graph0.getOrDefault(g[0], new HashSet<>());
            set.add(g[1]);
            graph0.put(g[0], set);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        // dfs
        while (!deque.isEmpty()){
            Integer cur = deque.removeFirst();
            if (cur == target){
                return true;
            }
            memo[cur] = true;
            for (Integer next : graph0.getOrDefault(cur, new HashSet<>())) {
                if (!memo[next]){
                    deque.addFirst(next);
                }
            }
        }
        return false;
    }

    // 使用数组代替哈希表，速度提升
    public boolean findWhetherExistsPath0(int n, int[][] graph, int start, int target) {

        if (target >= n)
            return false;
        boolean[] memo = new boolean[n];
        List<Integer>[] graph0 = new ArrayList[n];
        // 构造邻接矩阵
        for (int[] g : graph) {
            int from = g[0];
            int to = g[1];
            if (graph0[from] == null)
                graph0[from] = new ArrayList<>();
            graph0[from].add(to);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        // dfs
        while (!deque.isEmpty()){
            Integer cur = deque.removeLast();
            if (cur == target){
                return true;
            }
            memo[cur] = true;
            List<Integer> nextList = graph0[cur];
            if (nextList == null)
                continue;
            for (Integer next : nextList) {
                if (!memo[next]){
                    deque.addLast(next);
                }
            }
        }
        return false;
    }
}

/* 1ms  能通过，但有BUG，需保证到达最后target的边在后面
class Solution {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] vis = new boolean[n];
        vis[start] = true;
        int len = graph.length;
        for(int i = 0; i < len; i++) {
            if(vis[graph[i][0]]) {
                vis[graph[i][1]] = true;
            }
        }
        return vis[target];
    }
}
 */
