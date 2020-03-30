import java.util.*;

class Solution {

    private int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public int maxDistance(int[][] grid) {

        int res = Integer.MAX_VALUE;
        if (grid.length <= 1) return -1;
        Queue<Node> landQueue = new LinkedList<>();
        List<Node> seaList = new ArrayList<>();

        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[0].length; y++){
                if (grid[x][y] == 1)
                    landQueue.add(new Node(x, y, 1));
                else
                    seaList.add(new Node(x, y, 0));
            }
        if (landQueue.size() == 0 || seaList.size() == 0)
            return -1;

        node:
        while (!landQueue.isEmpty()){

            int size = landQueue.size();
            for (int n = 0; n < size; n++) {
                Node land = landQueue.remove();

                for (int i = 0; i < dir.length; i++) {
                    int newX = land.x + dir[i][0];
                    int newY = land.y + dir[i][1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid.length
                            && grid[newX][newY] == 0) {
                        grid[newX][newY] = land.val + 1;
                        landQueue.add(new Node(newX, newY, land.val + 1));
                        if (seaList.size() > 1)
                            seaList.remove(new Node(newX, newY, 0));
                    }
                }

                if (seaList.size() == 1) {
                    for (int i = 0; i < dir.length; i++) {
                        int newX = seaList.get(0).x + dir[i][0];
                        int newY = seaList.get(0).y + dir[i][1];
                        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid.length)
                            res = Math.min(grid[newX][newY], res);
                    }
                    break node;
                }
            }
        }

        return res;
    }

    class Node{
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y &&
                    val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, val);
        }
    }
}

/*
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxDistance(int[][] grid) {
        // 方向向量
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 由于题目中给出了 grid 的范围，因此不用做输入检查
        int N = grid.length;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(getIndex(i, j, N));
                }
            }
        }

        int size = queue.size();
        if (size == 0 || size == N * N) {
            return -1;
        }

        int step = 0;
        while (!queue.isEmpty()) {

            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                Integer head = queue.poll();

                int currentX = head / N;
                int currentY = head % N;

                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];

                    // 只关心有效范围内的海洋（0）
                    if (inArea(newX, newY, N) && grid[newX][newY] == 0) {
                        // 赋值成为一个不等于 0 的整数均可，因为后续逻辑只关心海洋（0）
                        grid[newX][newY] = 1;
                        queue.add(getIndex(newX, newY, N));
                    }
                }
            }

            step++;
        }
        // 由于最后一步，没有可以扩散的的区域，但是 step 加了 1，故在退出循环的时候应该减 1
        return step - 1;
    }


    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    private boolean inArea(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static void main(String[] args) {
        // int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Solution solution = new Solution();
        int res = solution.maxDistance(grid);
        System.out.println(res);
    }
}
*/


/* Dijkstra 版
class Solution {
public:
    static constexpr int MAX_N = 100 + 5;
    static constexpr int INF = int(1E6);
    static constexpr int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    int n;
    int d[MAX_N][MAX_N];

    struct Status {
        int v, x, y;
        bool operator < (const Status &rhs) const {
            return v > rhs.v;
        }
    };

    priority_queue <Status> q;

    int maxDistance(vector<vector<int>>& grid) {
        this->n = grid.size();
        auto &a = grid;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                d[i][j] = INF;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a[i][j]) {
                    d[i][j] = 0;
                    q.push({0, i, j});
                }
            }
        }

        while (!q.empty()) {
            auto f = q.top(); q.pop();
            for (int i = 0; i < 4; ++i) {
                int nx = f.x + dx[i], ny = f.y + dy[i];
                if (!(nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= n - 1)) continue;
                if (f.v + 1 < d[nx][ny]) {
                    d[nx][ny] = f.v + 1;
                    q.push({d[nx][ny], nx, ny});
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!a[i][j]) ans = max(ans, d[i][j]);
            }
        }

        return (ans == INF) ? -1 : ans;
    }
};
 */