class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        if (matrix[0][0] > target || matrix[m-1][n-1] < target)
            return false;
        for (int[] row : matrix) {
            for (int cur : row) {
                if (cur == target)
                    return true;
            }
        }
        return false;
    }
}
