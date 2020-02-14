import java.util.Arrays;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (m > 0 && n > 0 && obstacleGrid[n-1][m-1] == 1)
            return 0;
        if (m == 1 && n == 1 && obstacleGrid[n-1][m-1] == 0)
            return 1;
        int[][] memo = new int[n][m];

        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i],0);
        memo[n-1][m-1] = 1;

        for (int x = n-1; x >= 0; x--){
            for (int y = m-1; y >= 0; y--){
                if (obstacleGrid[x][y] == 0) {
                    if (x + 1 < n && y + 1 < m
                            && obstacleGrid[x+1][y] == 0 && obstacleGrid[x][y+1] == 0)
                        memo[x][y] = memo[x + 1][y] + memo[x][y + 1];
                    else if (x + 1 < n && y + 1 < m
                            && obstacleGrid[x+1][y] == 1 && obstacleGrid[x][y+1] == 0)
                        memo[x][y] = memo[x][y + 1];
                    if (x + 1 < n && y + 1 < m
                            && obstacleGrid[x+1][y] == 0 && obstacleGrid[x][y+1] == 1)
                        memo[x][y] = memo[x + 1][y];
                    else if (x + 1 < n && y + 1 >= m
                            && obstacleGrid[x+1][y] == 0)
                        memo[x][y] = memo[x + 1][y];
                    else if (x + 1 >= n && y + 1 < m
                            && obstacleGrid[x][y+1] == 0)
                        memo[x][y] = memo[x][y + 1];
                }
            }
        }

        return memo[0][0];
    }
}