class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0 || matrix[0][0] > target || matrix[m-1][n-1] < target)
            return false;
        return dfs(matrix, target, 0, 0, new boolean[m][n]);
    }

    private boolean dfs(int[][] matrix, int target, int x, int y, boolean[][] visit){
        if (matrix[x][y] == target)
            return true;
        if (visit[x][y])
            return false;
        visit[x][y] = true;
        return (x + 1 < matrix.length && matrix[x+1][y] <= target
                && dfs(matrix, target, x + 1, y, visit))
                || (y + 1 < matrix[0].length && matrix[x][y+1] <= target
                && dfs(matrix, target, x, y + 1, visit));
    }
}

/* 6ms
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int r = 0, c = matrix[0].length - 1;
        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target)
                return true;
            if(matrix[r][c] > target){
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
 */
