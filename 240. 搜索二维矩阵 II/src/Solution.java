class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n){
            if (matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                i --;
            else
                j ++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchMatrix(new int[][]{{-5}}, -5);
    }
}
