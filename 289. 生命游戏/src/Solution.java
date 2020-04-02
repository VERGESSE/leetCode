
class Solution {

    private int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},
                            {1,0},{1,1},{0,1},{-1,1}};

    public void gameOfLife(int[][] board) {

        if (board.length < 1 || board[0].length < 1) return;
        int m = board.length,n = board[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++)
            System.arraycopy(board[i],0, copy[i],0, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                int live = 0;
                for (int k = 0; k < dir.length; k++){
                    int newX = i + dir[k][0];
                    int newY = j + dir[k][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n){
                        if (copy[newX][newY] == 1)
                            live++;
                    }
                }
                if (copy[i][j] == 1 && live < 2)
                    board[i][j] = 0;
                else if (copy[i][j] == 1 && live > 1 && live < 4)
                    continue;
                else if (copy[i][j] == 1 && live > 3)
                    board[i][j] = 0;
                else if (copy[i][j] == 0 && live == 3)
                    board[i][j] = 1;
            }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        solution.gameOfLife(board);
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

/*   O(1)空间
规则 1：如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡。这时候，将细胞值改为 -1，代表这个细胞过去是活的现在死了；

规则 2：如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活。这时候不改变细胞的值，仍为 1；

规则 3：如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡。这时候，将细胞的值改为 -1，代表这个细胞过去是活的现在死了。可以看到，因为规则 1 和规则 3 下细胞的起始终止状态是一致的，因此它们的复合状态也一致；

规则 4：如果死细胞周围正好有三个活细胞，则该位置死细胞复活。这时候，将细胞的值改为 2，代表这个细胞过去是死的现在活了。

class Solution {
    public void gameOfLife(int[][] board) {

        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }

        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
 */