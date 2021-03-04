import java.util.*;

class Solution {
    private List<List<Integer>> edges;
    private boolean[] used;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        edges = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            edges.add(i, new ArrayList<>());
        }
        for (int[] conn : connections) {
            edges.get(conn[0]).add(conn[1]);
            edges.get(conn[1]).add(conn[0]);
        }

        used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                dfs(i);
                ++ans;
            }
        }

        return ans - 1;
    }

    private void dfs(int u) {
        used[u] = true;
        for (int v : edges.get(u)) {
            if (!used[v]) {
                dfs(v);
            }
        }
    }
}

/* 并查集
class Solution {

    private int[] parent;

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];

        // 并查集初始化
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        // cnt：网络中节点数量  red：多余的边数
        int cnt = 1, red = 0;

        for(int[] connection : connections){
            // 当前节点都在网络中了，这条连接多余了，多余的边数+1
            if(connected(connection[0], connection[1])){
                red++;
            }else{
            // 两个节点中有一个节点不在网络中，把新节点加入网络，网络中节点数量+1
                union(connection[0], connection[1]);
                cnt++;
            }
        }

        // 最后判断是否所有节点都在网络中，多余的边数够不够把剩下的节点连上网络
        cnt = n - cnt;
        return cnt == 0 ? 0 : red >= cnt ? cnt : -1;
    }

    // 并
    private void union(int p, int q){
        int rootP = find(p), rootQ = find(q);
        if(rootP == rootQ) return;
        parent[rootP] = parent[rootQ];
    }

    // 查
    private int find(int p){
        while(parent[p] != p){
            // 路径压缩
            parent[p] = parent[parent[p]];

            p = parent[p];
        }
        return p;
    }

    // 判断两节点是否同在一个网络中
    private boolean connected(int p, int q){
        return find(p) == find(q);
    }
}
 */
