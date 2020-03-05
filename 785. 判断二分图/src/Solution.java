class Solution {

    private boolean[] visited;
    private int[] colors;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int V = graph.length;
        colors = new int[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++){
            if (!visited[i])
                if (!dfs(i,0)) return false;
        }
        return true;
    }

    private boolean dfs(int v, int color) {

        visited[v] = true;
        colors[v] = color;
        for (int w : graph[v]){
            if (!visited[w]){
                if (!dfs(w,1-color)) return false;
            }else if (colors[w] == colors[v])
                return false;
        }

        return true;
    }
}