class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int m = rowSum.length;
        int n = colSum.length;
        int[][] martix = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                martix[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= martix[i][j];
                colSum[j] -= martix[i][j];
            }
        }

        return martix;
    }
}
