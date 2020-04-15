
class Solution {

    int m,n;
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    boolean[][] memo;

    public int[][] updateMatrix(int[][] matrix) {

        m = matrix.length;
        if (m == 0) return matrix;
        n = matrix[0].length;
        if (n == 0) return matrix;
        memo = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int  j = 0; j < n; j++){
                if (matrix[i][j] != 0) {
                    dfs(i, j, matrix);
                }
            }
        }

        return matrix;
    }

    private void dfs(int x, int y, int[][] matrix){
        if (memo[x][y]) return;
        memo[x][y] = true;

        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++){
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >=0 && newX < m && newY >= 0 && newY < n){
                if (matrix[newX][newY] == 0)
                    return;
                if (!memo[newX][newY])
                    dfs(newX, newY, matrix);
                temp = Math.min(temp, matrix[newX][newY] + 1);
            }
        }
        matrix[x][y] = temp;
        memo[x][y] = false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,0},{1,1,1},{1,1,1}};
        Solution solution = new Solution();
        solution.updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

    }
}

/*  dp
对于任一点 (i, j)(i,j)，距离 00 的距离为：
因此我们用 dp[i][j]dp[i][j] 来表示该位置距离最近的 0 的距离。
我们发现 dp[i][j]dp[i][j] 是由其上下左右四个状态来决定，无法从一个方向开始递推！

于是我们尝试将问题分解：

距离 (i, j)(i,j) 最近的 00 的位置，是在其 「左上，右上，左下，右下」4个方向之一；
因此我们分别从四个角开始递推，就分别得到了位于「左上方、右上方、左下方、右下方」距离 (i, j)(i,j) 的最近的 00 的距离，取 minmin 即可；
通过上两步思路，我们可以很容易的写出 44 个双重 forfor 循环，动态规划的解法写到这一步其实已经完全 OKOK 了；
如果第三步还不满足的话，从四个角开始的 44 次递推，其实还可以优化成从任一组对角开始的 22 次递推，比如只写从左上角、右下角开始递推就行了，为啥这样可以呢？且听我不负责任的草率论证 = = #
首先从左上角开始递推 dp[i][j]dp[i][j] 是由其 「左方」和 「左上方」的最优子状态决定的；
然后从右下角开始递推 dp[i][j]dp[i][j] 是由其 「右方」和 「右下方」的最优子状态决定的；
看起来第一次递推的时候，把「右上方」的最优子状态给漏掉了，其实不是的，因为第二次递推的时候「右方」的状态在第一次递推时已经包含了「右上方」的最优子状态了；
看起来第二次递推的时候，把「左下方」的最优子状态给漏掉了，其实不是的，因为第二次递推的时候「右下方」的状态在第一次递推时已经包含了「左下方」的最优子状态了。

class Solution {
  public int[][] updateMatrix(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
      }
    }

    // 从左上角开始
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i - 1 >= 0) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
        }
        if (j - 1 >= 0) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
        }
      }
    }
    // 从右下角开始
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (i + 1 < m) {
          dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
        }
        if (j + 1 < n) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
        }
      }
    }
    return dp;
  }
}

 */

/*  bfs
首先把每个源点 00 入队，然后从各个 00 同时开始一圈一圈的向 11 扩散
（每个 11 都是被离它最近的 00 扩散到的 ），扩散的时候可以设置 int[][] dist
 来记录距离（即扩散的层次）并同时标志是否访问过。对于本题是可以直接修改原数组 int[][]
  matrix 来记录距离和标志是否访问的，这里要注意先把 matrix 数组中 1 的位置设置成 -1
  （设成Integer.MAX_VALUE啦，m * n啦，10000啦都行，只要是个无效的距离值来标志这个位置的
   1 没有被访问过就行辣~）


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return matrix;
    }
}

 */