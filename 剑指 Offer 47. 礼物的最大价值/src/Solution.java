// 优化，减少判断次数
class Solution {
    public int maxValue(int[][] grid) {

        int m = grid.length - 1;
        if(m < 0) return 0;
        int n = grid[0].length - 1;
        if(n < 0) return 0;
        for(int i = n - 1; i >= 0; i--){
            grid[m][i] += grid[m][i+1];
        }
        for(int i = m - 1; i >= 0; i--){
            grid[i][n] += grid[i+1][n];
        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                grid[i][j] += Math.max(grid[i][j + 1], grid[i + 1][j]);
            }
        }
        return grid[0][0];
    }
}

/*
class Solution {
    public int maxValue(int[][] grid) {

        int m = grid.length;
        if(m < 1) return 0;
        int n = grid[0].length;
        if(n < 1) return 0;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int max = 0;
                if(i + 1 < m)
                    max = Math.max(max, grid[i + 1][j]);
                if(j + 1 < n)
                    max = Math.max(max, grid[i][j + 1]);
                grid[i][j] += max;
            }
        }
        return grid[0][0];
    }
}
*/
