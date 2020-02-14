import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {

        if (m < 0 || n < 0) return 0;
        int[][] memo = new int[n][m];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i],1);

        for (int x = n-1; x >= 0; x--){
            for (int y = m-1; y >= 0; y--){
                if (x+1 < n && y+1 < m)
                    memo[x][y] = memo[x+1][y] + memo[x][y+1];
                else if (x+1 < n && y+1 >= m)
                    memo[x][y] = memo[x+1][y];
                else if (x+1 >= n && y+1 < m)
                    memo[x][y] = memo[x][y+1];
            }
        }

        return memo[0][0];
    }
}