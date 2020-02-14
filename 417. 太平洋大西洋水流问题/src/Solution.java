import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> pacificAtlantic = new ArrayList<>();
    boolean[][] pacificMap;
    boolean[][] atlanticMap;
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int m,n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length < 1) return pacificAtlantic;
        m = matrix.length;
        n = matrix[0].length;
        pacificMap = new boolean[m][n];
        atlanticMap = new boolean[m][n];

        for (int x = 0; x < m; x++){
            for (int y = 0; y < n; y++){
                if (x == 0 || y == 0)
                    dfs(matrix,pacificMap,x,y);
                if (x == m-1 || y == n-1)
                    dfs(matrix,atlanticMap,x,y);
            }
        }

        for (int x = 0; x < m; x++){
            for (int y = 0; y < n; y++){
                if (pacificMap[x][y] && atlanticMap[x][y]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    pacificAtlantic.add(list);
                }
            }
        }

        return pacificAtlantic;
    }

    private void dfs(int[][] matrix,boolean[][] map, int x, int y) {

        map[x][y] = true;
        for (int i = 0; i < 4; i++){
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if (newX >= 0 && newY >= 0 && newX < m && newY < n
                    && !map[newX][newY]
                        && matrix[newX][newY] >= matrix[x][y]){
                dfs(matrix,map,newX,newY);
            }
        }
        return;
    }
}