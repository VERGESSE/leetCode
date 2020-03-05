import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},
                            {1,0},{1,-1},{0,-1},{-1,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid == null) return 0;
        int R = grid.length;
        if (R == 0) return 0;
        int C = grid[0].length;
        if (C == 0) return 0;
        if (grid[0][0] == 1) return -1;
        if (grid[R - 1][C - 1] == 1) return -1;
        if (R == 1 && C == 1) return 1;
        boolean[][] visited = new boolean[R][C];
        int[][] dis = new int[R][C];

        //BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        dis[0][0] = 1;
        while (!queue.isEmpty()){
            int cur = queue.remove();
            int curX = cur/R;
            int curY = cur%C;
            for (int i = 0; i < 8; i++){
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C
                        && grid[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    queue.add(nextX * C + nextY);
                    visited[nextX][nextY] = true;
                    dis[nextX][nextY] = dis[curX][curY] + 1;

                    if (nextX == R - 1 && nextY == C - 1)
                        return dis[nextX][nextY];
                }
            }
        }

        return -1;
    }
}