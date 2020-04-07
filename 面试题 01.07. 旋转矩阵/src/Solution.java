
class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        if (n == 0) return;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++)
            System.arraycopy(matrix[i],0,temp[i],0,n);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[j][n-i-1] = temp[i][j];
            }
        }
    }
}

/*
原地算法

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
 */