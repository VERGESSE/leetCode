class Solution {
    public int minPathSum(int[][] grid) {

        if (grid.length < 1) return 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int x = m-1; x >= 0; x--){
            for (int y = n-1; y >= 0; y--){
                if (x+1 < m && y+1 < n)
                    grid[x][y] = grid[x][y] + Math.min(grid[x+1][y],grid[x][y+1]);
                else if (x+1 < m && y+1 >=n)
                    grid[x][y] = grid[x][y] + grid[x+1][y];
                else if (x+1 >= m && y+1 <n)
                    grid[x][y] = grid[x][y] + grid[x][y+1];
            }
        }

        return grid[0][0];
    }
}