import java.util.*;

class Solution {

    private static final int[][] dirs = new int[][]{
            {0, 1}, {1, 0}
    };

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

        int r = obstacleGrid.length;
        if (r == 0)
            return new ArrayList<>();
        int c = obstacleGrid[0].length;
        if (c == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[r-1][c-1] == 1)
            return new ArrayList<>();

        int[] path = new int[r * c];
        // 迭代模拟栈
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] memo = new boolean[r * c];
        deque.add(0);
        while (!deque.isEmpty()){
            Integer cur = deque.removeLast();
            if (memo[cur]){
                continue;
            }
            memo[cur] = true;
            int y = cur % c;
            int x = (cur - y) / c;
            if (x == r-1 && y == c-1) {
                // 如果找到结果，deque必不为空
                deque.add(0);
                break;
            }
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                int xy = newX * c + newY;
                if (newX < r && newY < c
                        && obstacleGrid[newX][newY] != 1
                        && !memo[xy]){
                    //深搜，不一定最短，但是快一点
                    deque.add(xy);
                    path[xy] = cur;
                }
            }
        }
        // deque为空，不能到达出口
        if(deque.isEmpty()){
            return new ArrayList<>();
        }
        // 获取路径
        int pre = (r - 1) * c + c - 1;
        LinkedList<List<Integer>> ret = new LinkedList<>();
        while (pre != 0){
            int y = pre % c;
            int x = (pre - y) / c;
            ret.addFirst(List.of(x, y));
            pre = path[pre];
        }
        ret.addFirst(List.of(0, 0));
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.pathWithObstacles(new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0}
        });
        System.out.println(lists);
    }
}

/* 1ms
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int r=0;
    int c=0;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null)
            return res;
        this.r=obstacleGrid.length;
        this.c=obstacleGrid[0].length;
        if(r==0||c==0||obstacleGrid[r-1][c-1]==1)
            return res;
        int[][] visit=new int[r][c];
        dfs(obstacleGrid,0,0,visit);
        return res;
    }
    public boolean dfs(int[][] board,int i,int j,int[][] visit){
        if(i>=r||j>=c||board[i][j]==1||visit[i][j]==1)
           return false;
        res.add(Arrays.asList(i,j));
        if(i==r-1&&j==c-1)
           return true;
        visit[i][j]=1;
        if(dfs(board,i+1,j,visit)||dfs(board,i,j+1,visit))
           return true;
        res.remove(res.size()-1);
        return false;
    }
}
 */
