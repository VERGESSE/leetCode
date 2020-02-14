class Solution {

    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] visited;
    int m,n;

    public int numIslands(char[][] grid) {

        if (grid.length < 1) return 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int res = 0;
        for (int x = 0; x < m; x++){
            for (int y = 0; y < n; y++){
                if (grid[x][y] == '1' && visited[x][y] == false) {
                    res++;
                    dfs(grid,x,y);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i++){
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n
                    && grid[newX][newY] == '1'
                        && !visited[newX][newY])
                dfs(grid,newX,newY);
        }
        return;
    }
}

/*  more
class Solution {
    void dfs(char[][] grid, int r, int c) {
	    int nr = grid.length;
	    int nc = grid[0].length;

	    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
	      return;
	    }

	    grid[r][c] = '0';
	    dfs(grid, r - 1, c);
	    dfs(grid, r + 1, c);
	    dfs(grid, r, c - 1);
	    dfs(grid, r, c + 1);
	  }

	  public int numIslands(char[][] grid) {
	    if (grid == null || grid.length == 0) {
	      return 0;
	    }

	    int nr = grid.length;
	    int nc = grid[0].length;
	    int num_islands = 0;
	    for (int r = 0; r < nr; ++r) {
	      for (int c = 0; c < nc; ++c) {
	        if (grid[r][c] == '1') {
	          ++num_islands;
	          dfs(grid, r, c);
	        }
	      }
	    }

	    return num_islands;
	  }
}
 */

/*  fast
class Solution {
   public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        } else {
            // dfs可达的节点改为0
            grid[r][c] = '0';
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
            dfs(grid, r + 1, c);
            dfs(grid, r - 1, c);
        }
    }
}
 */