class Solution {

    private int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    private int R,C;
    private boolean[][] visited;
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null) return 0;

        R = grid.length;
        if (R == 0) return 0;

        C = grid[0].length;
        if (C == 0) return 0;

        visited = new boolean[R][C];
        this.grid = grid;

        int res = 0;
        for (int x = 0; x < R; x++)
            for (int y = 0; y < C; y++)
                if (grid[x][y] == 1 && !visited[x][y])
                    res = Math.max(res, dfs(x, y));

                return res;
    }

    private int dfs(int x, int y) {

        visited[x][y] = true;
        int res = 1;
        for (int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C &&
                grid[nextX][nextY] == 1 && !visited[nextX][nextY])
                res += dfs(nextX,nextY);
        }

        return res;
    }

}