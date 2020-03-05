class Solution {
    public int numEnclaves(int[][] A) {
        int X = A.length;
        int Y = A[0].length;

        for (int i = 0; i < X; i++) {
            dfs(A, X, Y, i, 0);
            dfs(A, X, Y, i, Y-1);
        }
        for (int j = 0; j < Y; j++) {
            dfs(A, X, Y, 0, j);
            dfs(A, X, Y, X-1, j);
        }
        int area = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (A[i][j] == 1) {
                    area++;
                }
            }
        }
        return area;
    }
    public void dfs(int[][] A, int X, int Y, int curX, int curY) {
        if (curX < 0 || curX >= X || curY < 0 || curY >= Y || A[curX][curY] == 0) {
            return;
        }
        A[curX][curY] = 0;
        dfs(A, X, Y, curX-1, curY);
        dfs(A, X, Y, curX+1, curY);
        dfs(A, X, Y, curX, curY-1);
        dfs(A, X, Y, curX, curY+1);
    }
}
