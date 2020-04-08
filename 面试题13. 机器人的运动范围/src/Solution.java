import java.util.LinkedList;
import java.util.Queue;

// bfs
class Solution {

    int[][] dir = {{1,0},{0,1}};

    public int movingCount(int m, int n, int k) {

        int res = 0;
        boolean[] memo = new boolean[m*n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            Integer point = queue.poll();
            if (memo[point]) continue;
            memo[point] = true;
            int x = point / n;
            int y = point - x*n;
            int temp = 0;

            int tempx = x;
            while (tempx > 0){
                temp += tempx%10;
                tempx = tempx/10;
            }

            int tempy = y;
            while (tempy > 0){
                temp += tempy%10;
                tempy = tempy/10;
            }

            if (temp <= k){
                res++;
                for (int i = 0; i < 2; i++){
                    int newX = x + dir[i][0];
                    int newY = y + dir[i][1];
                    if (newX < m && newY < n && !memo[newX*n+newY]){
                        queue.add(newX*n+newY);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(3,1,0));
    }
}
//dfs
/*
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x == m || y == n || getNumericalDigit(x) + getNumericalDigit(y) > k || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        // 可行区域在原点的右上方，所以只向右和向上拓展就行了
        return 1 + dfs(x + 1, y, m, n, k, visited) + dfs(x, y + 1, m, n, k, visited);
    }

    // 获取一个整数的数位和
    private int getNumericalDigit(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
 */